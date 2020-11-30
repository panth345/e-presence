package com.official.g2s.epresence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity{

    LinearLayout studentSignupLayout,teacherSignupLayout;

    private static final String TAG = "SignUp";
    String studentGender,teacherGender,batch,trade,department;


    EditText rollNoStudent,nameStudent,emailStudent,phoneStudent,passwordStudent,confirmPasswordStudent;
    EditText nameTeacher,emailTeacher,phoneTeacher,passwordTeacher,confirmPasswordTeacher;

    RadioGroup radioGroupStudent;
    RadioGroup radioGroupTeacher;

    Spinner occupationSpinner,batchSpinner,tradeSpinner;
    Spinner departmentSpinner;

    Button signupStudentButton,signupTeacherButton;

    HintAdapter hintAdapterOccupation,hintAdapterBatch,hintAdapterTrade,hintAdapterDepartment;

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up); // Spinner element

        studentSignupLayout = (LinearLayout) findViewById(R.id.studentSignupLayout);
        teacherSignupLayout = (LinearLayout) findViewById(R.id.teacherSignupLayout);


        rollNoStudent=(EditText)findViewById(R.id.rollNoEditText);
        nameStudent=(EditText)findViewById(R.id.nameEditText);
        emailStudent=(EditText)findViewById(R.id.emailEditText);
        phoneStudent=(EditText)findViewById(R.id.PhoneEditText);
        passwordStudent=(EditText)findViewById(R.id.passwordEditText);
        confirmPasswordStudent=(EditText)findViewById(R.id.confirmPasswordEditText);



        nameTeacher=(EditText)findViewById(R.id.teacherNameEditText);
        emailTeacher=(EditText)findViewById(R.id.teacherEmailEditText);
        phoneTeacher=(EditText)findViewById(R.id.teacherPhoneEditText);
        passwordTeacher=(EditText)findViewById(R.id.teacherPasswordEditText);
        confirmPasswordTeacher=(EditText)findViewById(R.id.teacherConfirmPasswordEditText);


        signupStudentButton=(Button)findViewById(R.id.signupButton);
        signupTeacherButton=(Button)findViewById(R.id.teacherSignupButton);

        mDatabaseHelper = new DatabaseHelper(this);



        radioGroupStudent = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroupStudent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.maleRadioButton:
                        studentGender="Male";
                        break;
                    case R.id.femaleRadioButton:
                        studentGender="Female";
                        break;
                }
            }
        });



        radioGroupTeacher = (RadioGroup) findViewById(R.id.teacherRadioGroup);
        radioGroupTeacher.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.maleTeacherRadioButton:
                        teacherGender="Male";
                        break;
                    case R.id.femaleTeacherRadioButton:
                        teacherGender="Female";
                        break;
                }
            }
        });



        occupationSpinner=(Spinner)findViewById(R.id.occupationSpinner);

        List<String> categoriesOccupation = new ArrayList<String>();
        categoriesOccupation.add("Teacher");
        categoriesOccupation.add("Student");
        categoriesOccupation.add("Please choose your option");

        hintAdapterOccupation=new HintAdapter(this,android.R.layout.simple_list_item_1,categoriesOccupation);
        occupationSpinner.setAdapter(hintAdapterOccupation);
        occupationSpinner.setSelection(hintAdapterOccupation.getCount());
        occupationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemOccupation = parent.getItemAtPosition(position).toString();

                if (itemOccupation.equals("Teacher")) {
                    studentSignupLayout.setVisibility(View.GONE);
                    teacherSignupLayout.setVisibility(View.VISIBLE);
                }
                else if (itemOccupation.equals("Student")) {
                    teacherSignupLayout.setVisibility(View.GONE);
                    studentSignupLayout.setVisibility(View.VISIBLE);
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                Toast.makeText(SignUp.this, "Please Select One Option from Teacher or Student to Continue", Toast.LENGTH_LONG).show();

            }

        });






        batchSpinner = (Spinner) findViewById(R.id.batchSpinner);
        List<String> categoriesBatch = new ArrayList<String>();
        categoriesBatch.add("2013");
        categoriesBatch.add("2014");
        categoriesBatch.add("2015");
        categoriesBatch.add("2016");
        categoriesBatch.add("2017");
        categoriesBatch.add("2018");
        categoriesBatch.add("Select Batch");

        hintAdapterBatch=new HintAdapter(this,android.R.layout.simple_list_item_1,categoriesBatch);
        batchSpinner.setAdapter(hintAdapterBatch);
        batchSpinner.setSelection(hintAdapterBatch.getCount());
        batchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemBatch = parent.getItemAtPosition(position).toString();
                batch=itemBatch;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });



        tradeSpinner = (Spinner) findViewById(R.id.tradeSpinner);
        List<String> categoriesTrade = new ArrayList<String>();
        categoriesTrade.add("B.Tech.CSE");
        categoriesTrade.add("B.Tech.ME");
        categoriesTrade.add("B.Tech.ECE");
        categoriesTrade.add("B.Tech.EE");
        categoriesTrade.add("B.Tech.CIVIL");
        categoriesTrade.add("MCA");
        categoriesTrade.add("Select Trade");

        hintAdapterTrade=new HintAdapter(this,android.R.layout.simple_list_item_1,categoriesTrade);
        tradeSpinner.setAdapter(hintAdapterTrade);

        tradeSpinner.setSelection(hintAdapterTrade.getCount());
        tradeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemTrade = parent.getItemAtPosition(position).toString();
                trade=itemTrade;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });





        departmentSpinner = (Spinner) findViewById(R.id.teacherDepartmentSpinner);
        List<String> categoriesDepartment = new ArrayList<String>();
        categoriesDepartment.add("B.Tech. CSE");
        categoriesDepartment.add("B.Tech. ME");
        categoriesDepartment.add("B.Tech. ECE");
        categoriesDepartment.add("B.Tech. EE");
        categoriesDepartment.add("B.Tech. CIVIL");
        categoriesDepartment.add("MCA");
        categoriesDepartment.add("Select Department");

        hintAdapterDepartment=new HintAdapter(this,android.R.layout.simple_list_item_1,categoriesDepartment);
        departmentSpinner.setAdapter(hintAdapterDepartment);

        departmentSpinner.setSelection(hintAdapterDepartment.getCount());
        departmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemDepartment = parent.getItemAtPosition(position).toString();
                department=itemDepartment;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

    signupStudentButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Toast.makeText(SignUp.this,"Student",Toast.LENGTH_LONG).show();




            String sdbRollNo=rollNoStudent.getText().toString();
            String sdbName=nameStudent.getText().toString();
            String sdbEmail=emailStudent.getText().toString();
            String sdbPhoneNo=phoneStudent.getText().toString();
            String sdbBatch=batch;
            String sdbTrade=trade;
            String sdbGender=studentGender;
            String sdbPassword=passwordStudent.getText().toString();
            String sdbConfirmPassword=confirmPasswordStudent.getText().toString();

            if(nameStudent.length() != 0)
            {
                if (sdbPassword.equals(sdbConfirmPassword)){

                    AddData(sdbRollNo,sdbName,sdbEmail,sdbPhoneNo,sdbBatch,sdbTrade,sdbGender,sdbPassword);
                    rollNoStudent.setText("");
                    nameStudent.setText("");
                    emailStudent.setText("");
                    phoneStudent.setText("");
                    passwordStudent.setText("");
                    confirmPasswordStudent.setText("");

                }
                else{
                    Toast.makeText(SignUp.this,"Password Not Matches, Try Again...",Toast.LENGTH_LONG).show();
                    passwordStudent.setText("");
                    confirmPasswordStudent.setText("");
                }
            }
            else
            {
                Toast.makeText(SignUp.this,"Please Enter Details",Toast.LENGTH_LONG).show();
            }

        }
    });

    signupTeacherButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Toast.makeText(SignUp.this,"Teacher",Toast.LENGTH_LONG).show();

            String sdbName=nameTeacher.getText().toString();
            String sdbEmail=emailTeacher.getText().toString();
            String sdbPhoneNo=phoneTeacher.getText().toString();
            String sdbGender=teacherGender;
            String sdbDepartment=department;
            String sdbPassword=passwordTeacher.getText().toString();
            String sdbConfirmPassword=confirmPasswordTeacher.getText().toString();

            if(nameTeacher.length() != 0)
            {
                if (sdbPassword.equals(sdbConfirmPassword)){

                    AddTeacherData(sdbName,sdbEmail,sdbPhoneNo,sdbGender,sdbDepartment,sdbPassword);
                    nameTeacher.setText("");
                    emailTeacher.setText("");
                    phoneTeacher.setText("");
                    passwordTeacher.setText("");
                    confirmPasswordTeacher.setText("");

                }
                else{
                    Toast.makeText(SignUp.this,"Password Not Matches, Try Again...",Toast.LENGTH_LONG).show();
                    passwordTeacher.setText("");
                    confirmPasswordTeacher.setText("");
                }
            }
            else
            {
                Toast.makeText(SignUp.this,"Please Enter Details",Toast.LENGTH_LONG).show();
            }

        }
    });


    }
    public void AddData(String sdbRollNo,String sdbName,String sdbEmail,String sdbPhoneNo,String sdbBatch,String sdbTrade,String sdbGender,String sdbPassword){

    boolean insertData = mDatabaseHelper.addData(sdbRollNo,sdbName,sdbEmail,sdbPhoneNo,sdbBatch,sdbTrade,sdbGender,sdbPassword);

        if (insertData) {
            Toast.makeText(SignUp.this, "Registered Successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(SignUp.this, "Error", Toast.LENGTH_LONG).show();
        }
    }
    public void AddTeacherData(String sdbName,String sdbEmail,String sdbPhoneNo,String sdbGender,String sdbDepartment,String sdbPassword){

        boolean insertData = mDatabaseHelper.addTeacherData(sdbName,sdbEmail,sdbPhoneNo,sdbGender,sdbDepartment,sdbPassword);

        if (insertData) {
            Toast.makeText(SignUp.this, "Registered Successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(SignUp.this, "Error", Toast.LENGTH_LONG).show();
        }
    }
}