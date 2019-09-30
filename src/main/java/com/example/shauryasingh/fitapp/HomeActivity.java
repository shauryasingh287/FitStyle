package com.example.shauryasingh.fitapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FloatingActionButton AddButton1=(FloatingActionButton) findViewById(R.id.AddButton1);
        final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.ProgressBar1);
        FloatingActionButton AddButton2=(FloatingActionButton) findViewById(R.id.AddButton2);
        final ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.ProgressBar2);
        mTextMessage = (TextView) findViewById(R.id.message);
        final TextView sleepText=(TextView) findViewById(R.id.sleepText);
        final TextView workText=(TextView) findViewById(R.id.workText);
        Button resetButton=(Button) findViewById(R.id.resetButton);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        progressBar1.setMax(16);
        progressBar1.setScaleY(4f);
        progressBar2.setMax(12);
        progressBar2.setScaleY(4f);
        progressBar1.setProgressTintList(ColorStateList.valueOf(Color.RED));
        progressBar2.setProgressTintList(ColorStateList.valueOf(Color.RED));

        sleepText.setText("You need to sleep for 8 hrs more");
        workText.setText("You need to work for 6 hrs more");

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar1.setProgress(0);
                progressBar2.setProgress(0);
                sleepText.setText("You need to sleep for 8 hrs more");
                workText.setText("You need to work for 6 hrs more");
                progressBar1.setProgressTintList(ColorStateList.valueOf(Color.RED));
                progressBar2.setProgressTintList(ColorStateList.valueOf(Color.RED));
            }
        });
        AddButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar1.setProgress(progressBar1.getProgress()+1);
                if(progressBar1.getProgress()==16){
                    sleepText.setText("You have completed the required hrs of sleep");
                    progressBar1.setProgressTintList(ColorStateList.valueOf(Color.GREEN));


                }

                else {
                    if(progressBar1.getProgress()%2==0)
                        sleepText.setText("You need to sleep for " + (16 - progressBar1.getProgress()) / 2 + " hrs more");
                    else
                        sleepText.setText("You need to sleep for " + (16 - progressBar1.getProgress()) / 2 + ".5 hrs more");

                }
            }
        });
        AddButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar2.setProgress(progressBar2.getProgress() + 1);

                if (progressBar2.getProgress() == 12) {
                    workText.setText("You have completed the required hrs of productivitty");
                    progressBar2.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
                }
                else {
                    if (progressBar2.getProgress() % 2 == 0) {
                        workText.setText("You need to work for " + (12 - progressBar2.getProgress()) / 2 + " hrs more" );
                    }
                    else {
                        workText.setText("You need to work for " + (12 - progressBar2.getProgress()) / 2 + ".5 hrs more");

                    }
                }
            }
        });


    }

}

