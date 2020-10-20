package com.geneticalgo.schedule;

import com.geneticalgo.schedule.entity.Department;

import com.geneticalgo.schedule.entity.Class;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Schedule {
    private boolean isFitnessChanged = true;
    private double fitness = -1;
    private ArrayList<Class> classes;
    private Data data;
    private int classNumb = 0;
    private int numberOfConflicts = 0;

    public Schedule(Data data) {
        this.data = data;
        classes = new ArrayList<>(data.getNumberOfClasses());
    }

    private Data getData() {
        return data;
    }

    public Schedule initialize() {
        new ArrayList<>(data.getDepts()).forEach(dept -> {
            dept.getCourses().forEach(course -> {
                Class newClass = new Class(classNumb++, dept, course);
                newClass.setMeetingTime(data.getMeetingTimes().get((int) (data.getMeetingTimes().size() * Math.random())));
                newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() * Math.random())));
                newClass.setInstructor(course.getInstructors().get((int) (course.getInstructors().size() * Math.random())));
                classes.add(newClass);
            });
        });
        return this;
    }

    public int getNumberOfConflicts() {
        return numberOfConflicts;
    }

    public double getFitness() {
        if (isFitnessChanged) {
            fitness = calculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    private double calculateFitness() {
        numberOfConflicts = 0;
        classes.forEach(x -> {
            if (x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumberOfStudents()) {
                numberOfConflicts++;
            }
            classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
                if (x.getMeetingTime() == y.getMeetingTime() && x.getId() != y.getId()) {
                    if (x.getRoom() == y.getRoom()) numberOfConflicts++;
                    if (x.getInstructor() == y.getInstructor()) numberOfConflicts++;
                }
            });
        });
        return 1/(double)(numberOfConflicts + 1);
    }

    public ArrayList<Class> getClasses() {
        isFitnessChanged = true;
        return classes;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < classes.size() - 1; i++) {
            result += classes.get(i) + ",";
        }
        result += classes.get(classes.size() - 1);
        return result;
    }
}
