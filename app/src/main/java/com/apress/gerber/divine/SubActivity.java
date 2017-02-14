package com.apress.gerber.divine;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;

/**
 * Created by hiroko on 2016/10/25.
 */

public class SubActivity extends AppCompatActivity {
    private static final String[] FORTUNE_TABLE = {"大吉", "吉", "中吉", "小吉", "末吉", "凶"};
    private TextView textName;
    private TextView result;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        TextView textName = (TextView) findViewById(R.id.textName);
        TextView result = (TextView)findViewById(R.id.result);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("Text") && !TextUtils.
                isEmpty(intent.getStringExtra("Text"))) {
            textName.setText(intent.getStringExtra("Text") + "さんの今日の運勢は…");
        } else {
            textName.setText("今日の運勢は…");
        }
        Random random = new Random();
        int i = random.nextInt(6);
        result.setText(FORTUNE_TABLE[i] + "です！");
    }

        public void setname(String name){
        textName.setText(name + "さんの今日の運勢は…");

    }


}




