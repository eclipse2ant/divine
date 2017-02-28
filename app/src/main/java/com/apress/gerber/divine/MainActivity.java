package com.apress.gerber.divine;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.Loader;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.apress.gerber.divine.DatabaseHelper.DB_DATE;
//import static com.apress.gerber.divine.DatabaseHelper.DB_NAME;


public class MainActivity extends AppCompatActivity {


    private EditText mEditText;
    private TextView pDisplayDate;
    private Button pPickDate;
    private int pYear;
    private int pMonth;
    private int pDay;
    private  long mStartTimeMillis;
    private DatabaseHelper mDbHelper;
    /** This integer will uniquely define the dialog to be used for displaying date picker.*/
    static final int DATE_DIALOG_ID = 0;

    private DatePickerDialog.OnDateSetListener pDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    pYear = year;
                    pMonth = monthOfYear;
                    pDay = dayOfMonth;
                    updateDisplay();
                    displayToast();
                }
            };

    /** Updates the date in the TextView */
    private void updateDisplay() {
        pDisplayDate.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append(pMonth + 1).append("/")
                        .append(pDay).append("/")
                        .append(pYear).append(" "));
    }

    /** Displays a notification when the date is updated */
    private void displayToast() {
        Toast.makeText(this, new StringBuilder().append("Date choosen is ").append(pDisplayDate.getText()),  Toast.LENGTH_SHORT).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Capture our View elements */
        pDisplayDate = (TextView) findViewById(R.id.displayDate);
        pPickDate = (Button) findViewById(R.id.pickDate);

        /** Listener for click event of the button */
        pPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        /** Get the current date */
        final Calendar cal = Calendar.getInstance();
        pYear = cal.get(Calendar.YEAR);
        pMonth = cal.get(Calendar.MONTH);
        pDay = cal.get(Calendar.DAY_OF_MONTH);

        /** Display the current date in the TextView */
        updateDisplay();


        Button btn = (Button) findViewById(R.id.activityChangeTextBtn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                mEditText = (EditText) findViewById(R.id.editText_name);

                intent.putExtra("Text", mEditText.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void saveJogViaSTP(){

        String strDate = new SimpleDateFormat("yyyy/MM/dd").format(mStartTimeMillis);

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.DB_DATE, strDate);

    }

    public void saveJog(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String strDate = new SimpleDateFormat("yyyy/MM/dd").format(mStartTimeMillis);

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.DB_DATE,strDate);
        try{
            db.insert(DatabaseHelper.TABLE_JOGRECORD, null, values);
        }catch (Exception e){
            Toast.makeText(this,"データの保存に失敗しました", Toast.LENGTH_SHORT).show();
        }finally {
            db.close();
        }
    }
    /** Create a new dialog for date picker */
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        pDateSetListener,
                        pYear, pMonth, pDay);
        }
        return null;
    }
}

