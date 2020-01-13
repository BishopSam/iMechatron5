package com.example.imechatron;

import java.io.Serializable;

public class CourseResult implements Serializable {
    private String courseCode;
    private String grade;
    private int noUnits;

    public CourseResult(String courseCode, String grade, int noUnits) {
        this.courseCode = courseCode;
        this.grade = grade;
        this.noUnits = noUnits;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getNoUnits() {
        return noUnits;
    }

    public void setNoUnits(int noUnits) {
        this.noUnits = noUnits;
    }
}
