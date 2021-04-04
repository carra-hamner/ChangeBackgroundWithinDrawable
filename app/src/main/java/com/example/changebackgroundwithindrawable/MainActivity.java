package com.example.changebackgroundwithindrawable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ImageButton imageButton;
    int[] images;
    private static final int GET_FROM_GALLERY = 1 ;
    public static final String  ACCOUNT_PROFILE_PHOTO = "PROFILE_PHOTO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
        imageButton = findViewById(R.id.imageButton);
        imageButton.setImageResource(R.drawable.ic_launcher_foreground);
        sharedPreferences = getSharedPreferences(ACCOUNT_PROFILE_PHOTO, MODE_PRIVATE);
        if(sharedPreferences.contains(ACCOUNT_PROFILE_PHOTO)) {
            sharedPreferences.getInt(ACCOUNT_PROFILE_PHOTO,R.drawable.ic_launcher_foreground);
        }


        imageButton.setOnClickListener(view -> {
            int aryLength = images.length;
            Random random = new Random();
            int rNum = random.nextInt(aryLength);
            Drawable drawable = getResources().getDrawable(images[rNum]);
            editor = sharedPreferences.edit();
            editor.putInt(ACCOUNT_PROFILE_PHOTO, images[rNum]);
            editor.apply();
            imageButton.setImageDrawable(drawable);
        });
    }
}