package com.example.demo.model;

public class JournalRecordExpanded {
    private int id;
    private int studentId;
    private int studyPlanId;
    private boolean inTime;
    private int count;
    private int markId;
    private String studentFullName;
    private String subjectName;
    private String subjectShortName;
    private String examType;
    private String markName;
    private String markValue;

    public JournalRecordExpanded(int id, int studentId, int study_plan_id, boolean in_time, int count, int markId,
                                 String studentFullName, String subjectName, String subjectShortName, String examType,
                                 String markName, String markValue) {
        this.id = id;
        this.studentId = studentId;
        this.studyPlanId = study_plan_id;
        this.inTime = in_time;
        this.count = count;
        this.markId = markId;
        this.studentFullName = studentFullName;
        this.subjectName = subjectName;
        this.subjectShortName = subjectShortName;
        this.examType = examType;
        this.markName = markName;
        this.markValue = markValue;
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

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectShortName() {
        return subjectShortName;
    }

    public void setSubjectShortName(String subjectShortName) {
        this.subjectShortName = subjectShortName;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public String getMarkValue() {
        return markValue;
    }

    public void setMarkValue(String markValue) {
        this.markValue = markValue;
    }
}
