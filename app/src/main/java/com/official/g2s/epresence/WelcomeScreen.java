package com.official.g2s.epresence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class WelcomeScreen extends AppCompatActivity {

    TextView signupTextView,welcomeTextView;
    Button teacherButton,studentButton;

    DatabaseHelper mDatabaseHelper;


    Button sLoginButton,tLoginButton;
    EditText usernameT,passwordT,usernameS,passwordS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        mDatabaseHelper = new DatabaseHelper(this);

        welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fadein);
        welcomeTextView.setAnimation(animation);


        signupTextView = (TextView) findViewById(R.id.signUpTextView);
        signupTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupActivity = new Intent(WelcomeScreen.this, SignUp.class);
                startActivity(signupActivity);
            }
        });


        teacherButton=(Button)findViewById(R.id.teacherButton);
        studentButton=(Button)findViewById(R.id.studentButton);

        teacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacherButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_pressed));
                studentButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_bg));
                Toast.makeText(WelcomeScreen.this,"Teacher",Toast.LENGTH_SHORT).show();
            }
        });


        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teacherButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_bg));
                studentButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_bg_pressed));
                Toast.makeText(WelcomeScreen.this,"Student",Toast.LENGTH_SHORT).show();
            }
        });

        sLoginButton=(Button)findViewById(R.id.sLoginButton);
        tLoginButton=(Button)findViewById(R.id.tLoginButton);

        usernameT=(EditText)findViewById(R.id.teacherUsernamefield);
        passwordT=(EditText)findViewById(R.id.teacherPasswordfield);

        usernameS=(EditText)findViewById(R.id.studentUsernamefield);
        passwordS=(EditText)findViewById(R.id.studentPasswordfield);

        sLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseHelper.getData(usernameS.getText().toString());
                Intent loginSuccess=new Intent(WelcomeScreen.this,StudentLogin.class);
                startActivity(loginSuccess);
                finish();
            }
        });
    }
}
