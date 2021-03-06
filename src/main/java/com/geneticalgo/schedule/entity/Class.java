package com.geneticalgo.schedule.entity;

public class Class {
    private int id;
    private Department department;
    private Course course;
    private Instructor instructor;
    private MeetingTime meetingTime;
    private Room room;

    public Class(int id, Department department, Course course) {
        this.id = id;
        this.department = department;
        this.course = course;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setMeetingTime(MeetingTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public Course getCourse() {
        return course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public MeetingTime getMeetingTime() {
        return meetingTime;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "[" + department.getName() + ", " +  course.getNumber() + ", " +  room.getNumber() + ", " +  instructor.getId() +", " +   meetingTime.getId() + "]";
    }
}
