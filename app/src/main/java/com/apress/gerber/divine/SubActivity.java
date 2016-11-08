package com.apress.gerber.divine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by hiroko on 2016/10/25.
 */

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent intent = this.getIntent();
        String text = intent.getStringExtra("MAIN_INPUT_STRING");

        TextView textView= (TextView)this.findViewById(R.id.sub_birthday);
        textView.setText(text);



    }

}

