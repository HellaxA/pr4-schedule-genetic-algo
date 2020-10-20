package com.geneticalgo.schedule.entity;

import java.util.ArrayList;

public class Course {
    private String number;
    private String name;
    private int maxNumberOfStudents;
    private ArrayList<Instructor> instructors;

    public Course(String number, String name, int maxNumberOfStudents, ArrayList<Instructor> instructors) {
        this.number = number;
        this.name = name;
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.instructors = instructors;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    @Override
    public String toString() {
        return name;
    }
}
