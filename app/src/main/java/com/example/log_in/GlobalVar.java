package com.example.log_in;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

public class GlobalVar {
    public static List<Integer> Anger = new ArrayList<>();
    public static List<Integer> confusion = new ArrayList<>();
    public static List<Integer> laugh = new ArrayList<>();
    public static List<Integer> Sad = new ArrayList<>();
    public static List<Integer> Surprised= new ArrayList<>();
    public static List<Integer> Smile = new ArrayList<>();
    public static List<Integer> OtherExpression = new ArrayList<>();
    GlobalVar()
    {
        Anger.add(R.drawable.anger) ; Anger.add(R.drawable.angery2);
        Anger.add(R.drawable.anger4);Anger.add(R.drawable.anger3);
        Anger.add(R.drawable.angercartoones);Anger.add(R.drawable.anger_carton3);

        confusion.add(R.drawable.haqer);confusion.add(R.drawable.haqer2);
        confusion.add(R.drawable.haqer3);confusion.add(R.drawable.haqer_cartoon);
    }
    public static  int position;

}
