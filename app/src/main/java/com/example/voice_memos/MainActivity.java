package com.example.voice_memos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import  androidx.appcompat.widget.Toolbar;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_recordings_screen);
         Toolbar toolbar = findViewById(R.id.toolbar);
        View view = getLayoutInflater().inflate(R.layout.edit_text, null);

        try {
               setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
           catch (NullPointerException e){
               Log.d("ssssssssssssss",e.toString());
           }



        TextView editText = view.findViewById(R.id.editText);
        if (editText != null) {
            Log.d("MainActivity", "Edit text found: " + editText.getText().toString());

            if (editText.getParent() != null) {
                ((ViewGroup) editText.getParent()).removeView(editText);
            }
        if (editText != null) {
            Toolbar.LayoutParams params = new Toolbar.LayoutParams(
                    Toolbar.LayoutParams.WRAP_CONTENT,
                    Toolbar.LayoutParams.WRAP_CONTENT,
                    Gravity.END
            );
            toolbar.addView(editText, params);

        } else {
            Log.d("ssssssssssssss","Saaaaaaaaaaaaa");

            // Handle the case where editText is null
        }
    }}
}