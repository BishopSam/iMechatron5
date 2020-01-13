package com.example.imechatron;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.imechatron.ResultActivity.KEY_CGPA;
import static com.example.imechatron.ResultActivity.KEY_COURSES;

public class GpCalculateActivity extends AppCompatActivity {

    private LinearLayout parentLayout;
    private TextView tvAddCourse;
    private Button btCalculate;

    private ArrayList<LinearLayout> linearLayouts;
    private ArrayList<EditText> editTexts;
    private ArrayList<Spinner> unitsSpinners;
    private ArrayList<Spinner> gradeSpinners;
    private ArrayList<ImageView> cancelButtons;

    private ArrayList<CourseResult> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gp_calc);

        parentLayout = findViewById(R.id.linear_layout);
        linearLayouts = new ArrayList<>();
        tvAddCourse = findViewById(R.id.tv_add_course);
        btCalculate = findViewById(R.id.bt_calculate);
        cancelButtons = new ArrayList<>();



        editTexts = new ArrayList<>();
        unitsSpinners = new ArrayList<>();
        gradeSpinners = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            addNewCourse();
        }

        tvAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewCourse();
            }
        });

        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gpa =calculateCGPA();
                if (gpa == null){
                    Toast.makeText(GpCalculateActivity.this, "You've not entered any course", Toast.LENGTH_SHORT).show();


                } else {
                    openResultActivity(gpa);
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        results = new ArrayList<>();

    }

    private void openResultActivity(String gpa) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(KEY_CGPA, gpa);
        intent.putExtra(KEY_COURSES, results);
        startActivity(intent);
    }

    private void addNewCourse() {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0,10);
        linearLayout.setLayoutParams(layoutParams);


        EditText editText = new EditText(this);
        LinearLayout.LayoutParams etLayoutParams = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.4f);
        etLayoutParams.setMargins(0, 0, 20,0);
        editText.setLayoutParams(etLayoutParams);
        editText.setHint("CSC 201");
        editText.setBackgroundColor(Color.WHITE);

        Spinner unitSpinner = new Spinner(this);
        ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter.createFromResource(this,
                R.array.course_units, android.R.layout.simple_spinner_item);
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(unitAdapter);
        LinearLayout.LayoutParams unitSpLayoutParams = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.25f);
        unitSpLayoutParams.setMargins(0, 0, 20,0);
        unitSpinner.setLayoutParams(unitSpLayoutParams);

        Spinner gradeSpinner = new Spinner(this);
        ArrayAdapter<CharSequence> gradeAdapter = ArrayAdapter.createFromResource(this,
                R.array.course_grade, android.R.layout.simple_spinner_item);
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gradeSpinner.setAdapter(gradeAdapter);
        LinearLayout.LayoutParams gradeSpLayoutParams = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.25f);
        gradeSpLayoutParams.setMargins(0, 0, 20,0);
        gradeSpinner.setLayoutParams(gradeSpLayoutParams);

        ImageView cancelImage = new ImageView(this);
        LinearLayout.LayoutParams imageLayoutParams = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 0.1f);
        cancelImage.setLayoutParams(imageLayoutParams);
        cancelImage.setImageResource(R.drawable.ic_cancel_black_24dp);
        cancelImage.setId(cancelButtons.size());
        cancelImage.setId(cancelButtons.size());
        cancelImage.setOnClickListener(removeCourseListener);


        editTexts.add(editText);
        unitsSpinners.add(unitSpinner);
        gradeSpinners.add(gradeSpinner);
        cancelButtons.add(cancelImage);
        linearLayouts.add(linearLayout);

        linearLayout.addView(editText);
        linearLayout.addView(unitSpinner);
        linearLayout.addView(gradeSpinner);
        linearLayout.addView(cancelImage);
        parentLayout.addView(linearLayout);
    }

    private String calculateCGPA() {
        int numberUnits = 0;
        double totalGP = 0;
        double gpa;

        for (int i = 0; i < editTexts.size(); i++){
            String courseCode = editTexts.get(i).getText().toString().trim();
            if (courseCode.equals("")){
                continue;
            }

            String unitString = unitsSpinners.get(i).getSelectedItem().toString();
            String gradeString = gradeSpinners.get(i).getSelectedItem().toString();
            int unit = Integer.parseInt(unitString);
            int grade = getGradePoint(gradeString);
            numberUnits += unit;
            int gradePoint = unit * grade;
            totalGP += gradePoint;
            CourseResult result = new CourseResult(courseCode, gradeString, unit);
            results.add(result);
        }

        if (results.size() == 0){
            return null;
        }
        gpa = totalGP / numberUnits;

        return String.format("%.2f", gpa);

    }

    private int getGradePoint(String gradeString) {
        int grade = 0;
        switch (gradeString){
            case "A":
                grade = 5;
                break;

            case "B":
                grade = 4;
                break;

            case "C":
                grade = 3;
                break;

            case "D":
                grade = 2;
                break;

            case "E":
                grade = 1;
                break;

            case "F":
                grade = 0;
                break;

        }

        return grade;
    }

    View.OnClickListener removeCourseListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            parentLayout.removeView(linearLayouts.get(id));
            linearLayouts.remove(id);
            editTexts.remove(id);
            unitsSpinners.remove(id);
            gradeSpinners.remove(id);
            cancelButtons.remove(id);
            resetCancelButtonsId();
        }
    };

    private void resetCancelButtonsId(){
        for (int i = 0; i < cancelButtons.size(); i++){
            cancelButtons.get(i).setId(i);
        }
    }
}
