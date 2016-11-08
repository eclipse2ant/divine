package com.apress.gerber.divine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn=(Button)findViewById(R.id.activityChangeTextBtn);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SubActivity.class);
                
                EditText editText = (EditText)findViewById(R.id.editText);

                intent.putExtra("MAIN_INPUT_STRING", editText.getText().toString());
                startActivity(intent);
            }
        });
    }



}

