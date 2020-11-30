package com.official.g2s.epresence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class StudentLogin extends AppCompatActivity {
    RelativeLayout calendarLayout,chooseSubjectLayout;
    Button okayButton,backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        calendarLayout=(RelativeLayout)findViewById(R.id.calendarLayout);
        chooseSubjectLayout=(RelativeLayout)findViewById(R.id.chooseSubjectLayout);

        okayButton=(Button)findViewById(R.id.okayButton);
        backButton=(Button)findViewById(R.id.backButton);

        okayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarLayout.setVisibility(View.VISIBLE);
                chooseSubjectLayout.setVisibility(View.INVISIBLE);

            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseSubjectLayout.setVisibility(View.VISIBLE);
                calendarLayout.setVisibility(View.INVISIBLE);

            }
        });

    }
}
