package com.example.demo.model;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String secondName;
    private int studyGroupId;


    public Student(int id, String surname, String name, String secondName, int studyGroupId) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.studyGroupId = studyGroupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(int studyGroupId) {
        this.studyGroupId = studyGroupId;
    }
}
