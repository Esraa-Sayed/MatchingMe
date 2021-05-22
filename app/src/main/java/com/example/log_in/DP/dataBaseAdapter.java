package com.example.log_in.DP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;

public class dataBaseAdapter {
    static dataBaseHelper dbHelper;
    private byte[] image;

    public dataBaseAdapter(Context context) {

        dbHelper = new dataBaseHelper(context);
    }

    private byte[] CheckSize(byte[] imagem_img) {

        while (imagem_img.length > 500000) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(imagem_img, 0, imagem_img.length);
            Bitmap resized = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 0.5), (int) (bitmap.getHeight() * 0.5), true);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            resized.compress(Bitmap.CompressFormat.PNG, 100, stream);
            imagem_img = stream.toByteArray();
        }
        return imagem_img;

    }

    // convert from bitmap to byte array
    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public long addEntry(SQL entry) {
        long id = -1;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues C = new ContentValues();
        C.put(dataBaseHelper.colnEmail, entry.getEmail());
        C.put(dataBaseHelper.colnName, entry.getName());
        C.put(dataBaseHelper.colnGender, entry.getGender());
        C.put(dataBaseHelper.colnPassward, entry.getPassward());
        if (entry.getB() != null) {
            byte[] image = getBytes(entry.getB());
            image = CheckSize(image);
            C.put(dataBaseHelper.colnImage, image);
        } else {
            C.put(dataBaseHelper.colnImage, (byte[]) null);
        }
        try {

            id = db.insert(dataBaseHelper.TableName, null, C);//Number of table which I'm inserting into it
        } catch (Exception e) {
            Log.e("TAG Error in data Base", e.getMessage() + "Error");
        }
        return id;
    }
    public int getEntryByID (String Em)
    {   int ID = -1;
        Cursor c;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            String query = "select " + dataBaseHelper.colnID + " from " + dataBaseHelper.TableName + " where " + dataBaseHelper.colnEmail + " = '" + Em + "'";
            c = db.rawQuery(query, null);
            if (c.moveToNext()) {
                ID = c.getInt(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TAG 1 *********** ", e.getMessage() + " Error");
        }
        return ID;
    }
    public SQL getEntry(int ID) {
        SQL entry = new SQL("", "", "", "");
        Cursor c;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            String query = "select "+ dataBaseHelper.colnEmail + " , " +  dataBaseHelper.colnName + " , " + dataBaseHelper.colnGender + " , "
                    + dataBaseHelper.colnPassward + " , " + dataBaseHelper.colnImage + " from " + dataBaseHelper.TableName + " where " + dataBaseHelper.colnID + " = '" + ID + "'";
            c = db.rawQuery(query, null);
            if (c.moveToNext()) {
                image = c.getBlob(4);
                if (image != null) {
                    Bitmap B = getImage(image);
                    entry = new SQL(c.getString(0), c.getString(1), c.getString(2),c.getString(3), B);
                    c.close();
                } else {
                    entry = new SQL(c.getString(0), c.getString(1), c.getString(2),c.getString(3));
                    c.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TAG 1 *********** ", e.getMessage() + " Error");
        }
        return entry;
    }

    public void Delete(int ID) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {
            db.execSQL("DELETE FROM " + dataBaseHelper.TableName + " WHERE " + dataBaseHelper.colnID + " = '" + ID + "'");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TAG 2 ", e.getMessage() + " Error");
        }
    }

    public void Delete_image_from_DataBase(int ID) {
        try {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues C = new ContentValues();
            try {
                C.put(dataBaseHelper.colnImage, (byte[]) null);
                String strFilter = dataBaseHelper.colnID + "='" + ID + "' ";
                db.update(dataBaseHelper.TableName, C, strFilter, null);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("TAG 3 ", e.getMessage() + " Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TAG 2 ", e.getMessage() + " Error");
        }
    }

    public void change_photo(int ID, Bitmap B) {
        image = getBytes(B);
        image = CheckSize(image);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues C = new ContentValues();
        try {
            C.put(dataBaseHelper.colnImage, image);
            String strFilter = dataBaseHelper.colnID + "='" + ID + "' ";
            db.update(dataBaseHelper.TableName, C, strFilter, null);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TAG 3 ", e.getMessage() + " Error");
        }
    }

    static class dataBaseHelper extends SQLiteOpenHelper {
        private static final int DB_Version = 1;
        private static final String DB_Name = "SQl.db", TableName = "Data";
        private static final String colnName = "Name";
        private static final String colnEmail = "Email";
        private static final String colnGender = "Gender";
        private static final String colnPassward = "Passward";
        private static final String colnImage = "Image";
        private static final String colnID = "ID";

        private static final String createTable = "CREATE TABLE " + TableName + " (" + colnEmail +
                " TEXT UNIQUE, " + colnName + " TEXT , " + colnGender
                + " TEXT , " + colnPassward + " TEXT ," + colnImage + " BLOB , " + colnID + " INTEGER PRIMARY KEY);";

        public dataBaseHelper(Context context) {

            super(context, DB_Name, null, DB_Version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
