package com.example.user.myapplication1024;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity1024 extends AppCompatActivity {
    CheckBox chk;
    RadioGroup rg;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1024);
        pb = (ProgressBar) findViewById(R.id.progressBar);

        chk = (CheckBox) findViewById(R.id.checkBox);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("MYLOG","chk:"+isChecked);
            }
        });
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton3)
                {
                    Log.d("MYLOG","select radioButton3");
                }
                else if(checkedId == R.id.radioButton4)
                {
                    Log.d("MYLOG","select radioButton4");
                }
                else if(checkedId == R.id.radioButton5)
                {
                    Log.d("MYLOG","select radioButton5");
                }
            }
        });






    }
    public void click1(View v)
    {
        EditText ed = (EditText)findViewById(R.id.editText);
        String str = ed.getText().toString();

        Intent it = new Intent();
        it.setAction(Intent.ACTION_SEND);
        it.setType("text/plain");
        it.putExtra(Intent.EXTRA_TEXT,str);
        startActivity(it);

    }
    public void click2(View v)
    {
        pb.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pb.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }.start();

    }
}
