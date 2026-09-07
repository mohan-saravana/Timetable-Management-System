package com.timetable.model;

public class Timetablemodel2 {

    private int id;
    private int classId;
    private String day;
    private int period;
    private int subjectId;
    private int teacherId;
    private int roomId;

    public Timetablemodel2() {
    }

    public Timetablemodel2(int id, int classId, String day,
                     int period, int subjectId,
                     int teacherId, int roomId) {

        this.id = id;
        this.classId = classId;
        this.day = day;
        this.period = period;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.roomId = roomId;
    }

    public Timetablemodel2(int classId, String day,
                     int period, int subjectId,
                     int teacherId, int roomId) {

        this.classId = classId;
        this.day = day;
        this.period = period;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {

        return "ID: " + id
                + " | Class ID: " + classId
                + " | Day: " + day
                + " | Period: " + period
                + " | Subject ID: " + subjectId
                + " | Teacher ID: " + teacherId
                + " | Room ID: " + roomId;
    }
}