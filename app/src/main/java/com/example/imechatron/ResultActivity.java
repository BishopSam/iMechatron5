package com.example.imechatron;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CourseResultAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public static final String KEY_CGPA = "cgpaString";
    public static final String KEY_COURSES = "courses";
    private ImageView imageResult;
    private TextView tvCgpa, tvRemark, tvClass, tvViewCourses;

    ArrayList<CourseResult> courseResults;
    String cgpaString;
    DegreeClass degreeClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        if (intent != null) {
            cgpaString = intent.getStringExtra(KEY_CGPA);
            courseResults = (ArrayList<CourseResult>) intent.getSerializableExtra(KEY_COURSES);
            degreeClass = getDegreeClass(cgpaString);

            mRecyclerView = findViewById(R.id.rv_result);
            mAdapter = new CourseResultAdapter(courseResults);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);


            imageResult = findViewById(R.id.image_result);
            tvCgpa = findViewById(R.id.tv_cgpa);
            tvRemark = findViewById(R.id.tv_remark);
            tvClass = findViewById(R.id.tv_class);
            tvViewCourses = findViewById(R.id.tv_view_courses);

         /*   if (intent != null) {
                cgpaString = intent.getStringExtra(KEY_CGPA);
                courseResults = (ArrayList<CourseResult>) intent.getSerializableExtra(KEY_COURSES);
                degreeClass = getDegreeClass(cgpaString);
           */     populateResult();


        }
    }

    private DegreeClass getDegreeClass(String cgpaString) {
        double cgpa = Double.parseDouble(cgpaString);
        DegreeClass degreeClass;
        if (cgpa >= 4.50 && cgpa <= 5.00){
            degreeClass = DegreeClass.FIRST_CLASS;
        } else if(cgpa >= 3.50 && cgpa <= 4.49){
            degreeClass = DegreeClass.SECOND_CLASS_UPPER;
        } else if(cgpa >= 2.50 && cgpa <= 3.49){
            degreeClass = DegreeClass.SECOND_CLASS_LOWER;
        } else if(cgpa >= 1.50 && cgpa <= 2.49){
            degreeClass = DegreeClass.THIRD_CLASS;
        } else if(cgpa >= 1.00 && cgpa <= 1.49){
            degreeClass = DegreeClass.PASS;
        } else {
            degreeClass = DegreeClass.FAIL;
        }
        return degreeClass;
    }

    private void populateResult() {
        imageResult.setImageResource(degreeClass.getClassIcon());
        tvCgpa.setText(cgpaString);
        tvRemark.setText(degreeClass.getClassRemark());
        tvClass.setText("You are in " + degreeClass.getClassName());
        tvViewCourses.setText("View " + courseResults.size() + " Results");

    }

    enum DegreeClass {
        FIRST_CLASS("First Class", "Excellent", R.drawable.ic_check_circle_black_24dp),
        SECOND_CLASS_UPPER("Second Class Upper", "Very Good", R.drawable.ic_check_circle_black_24dp),
        SECOND_CLASS_LOWER("Second Class Class Lower", "Fair", R.drawable.ic_error_grey_24dp),
        THIRD_CLASS("Third Class", "You need to buckle up", R.drawable.ic_error_grey_24dp),
        PASS("Pass", "Concentrate on your books", R.drawable.ic_error_red_24dp),
        FAIL("Fail", "Guy, school no be for you abeg", R.drawable.ic_cancel_black_24dp);

        String className;
        String classRemark;
        int classIcon;

        DegreeClass(String className, String classRemark, int classIcon) {
            this.className = className;
            this.classRemark = classRemark;
            this.classIcon = classIcon;

        }

        public String getClassName() {
            return className;
        }

        public String getClassRemark() {
            return classRemark;
        }

        public int getClassIcon() {
            return classIcon;
        }
    }
}
