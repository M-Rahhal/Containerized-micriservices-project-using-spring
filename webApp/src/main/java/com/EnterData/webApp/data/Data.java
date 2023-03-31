package com.EnterData.webApp.data;

import java.util.ArrayList;

public class Data {
    private String data;
    private String studentName;
    private double grade;


    public Data(){

    }
    public void generateStudent(String s){
        studentName = s.split(":")[0];
        grade = Double.parseDouble(s.split(":")[1]);
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
