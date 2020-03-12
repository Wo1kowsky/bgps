package com.example.demo.model;

public class JournalRecord {
    private int id;
    private int studentId;
    private int studyPlanId;
    private boolean inTime;
    private int count;
    private int markId;

    public JournalRecord(int id, int studentId, int studyPlanId, boolean inTime, int count, int markId) {
        this.id = id;
        this.studentId = studentId;
        this.studyPlanId = studyPlanId;
        this.inTime = inTime;
        this.count = count;
        this.markId = markId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudyPlanId() {
        return studyPlanId;
    }

    public void setStudyPlanId(int studyPlanId) {
        this.studyPlanId = studyPlanId;
    }

    public boolean isInTime() {
        return inTime;
    }

    public void setInTime(boolean inTime) {
        this.inTime = inTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }
}
