package com.analytics.model;

public class StudentGrades {
    private String studentName;
    private double grade;

    public StudentGrades() {
    }

    public StudentGrades(String studentName, double grade) {
        this.studentName = studentName;
        this.grade = grade;
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
}
