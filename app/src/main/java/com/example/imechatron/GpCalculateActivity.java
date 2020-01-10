package com.example.imechatron;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GpCalculateActivity extends AppCompatActivity {
    Button btGPA;

    Spinner tnu, grade1, creditunit1, grade2, creditunit2, grade3, creditunit3, grade4, creditunit4, grade5 , creditunit5,
            grade6, creditunit6,
            grade7, creditunit7,grade8, creditunit8, grade9, creditunit9, grade10, creditunit10, grade11, creditunit11;

    EditText etSemester, etCode1, etCode2, etCode3, etCode4, etCode5, etCode6, etCode7, etCode8, etCode9, etCode10, etCode11;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gp_calc);

        btGPA=findViewById(R.id.bt_calc);
        tnu =findViewById(R.id.spinner_tnu);
        grade1 =findViewById(R.id.spinner1);
        creditunit1=findViewById(R.id.spinner2);

        grade2 =findViewById(R.id.spinner3);
        creditunit2=findViewById(R.id.spinner4);

        grade3 =findViewById(R.id.spinner5);
        creditunit3=findViewById(R.id.spinner6);

        grade4 =findViewById(R.id.spinner7);
        creditunit4=findViewById(R.id.spinner8);

        grade5 =findViewById(R.id.spinner9);
        creditunit5=findViewById(R.id.spinner10);

        grade6 =findViewById(R.id.spinner11);
        creditunit6=findViewById(R.id.spinner12);

        grade7 =findViewById(R.id.spinner13);
        creditunit7=findViewById(R.id.spinner14);

        grade8 =findViewById(R.id.spinner15);
        creditunit8=findViewById(R.id.spinner16);

        grade9 =findViewById(R.id.spinner17);
        creditunit9 =findViewById(R.id.spinner18);

        grade10 =findViewById(R.id.spinner19);
        creditunit10 =findViewById(R.id.spinner20);

        grade11 =findViewById(R.id.spinner21);
        creditunit11 =findViewById(R.id.spinner22);

        etSemester=findViewById(R.id.et_semester);
        etCode1=findViewById(R.id.et1);
        etCode2=findViewById(R.id.et2);
        etCode3=findViewById(R.id.et3);
        etCode4=findViewById(R.id.et4);
        etCode5=findViewById(R.id.et5);
        etCode6=findViewById(R.id.et6);
        etCode7=findViewById(R.id.et7);
        etCode8=findViewById(R.id.et8);
        etCode9=findViewById(R.id.et9);
        etCode10=findViewById(R.id.et10);
        etCode11=findViewById(R.id.et11);




    }




}
