package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.dao.StudyGroupJdbc;
import  com.example.demo.model.StudyGroup;

import java.util.List;

@RestController
public class StudyGroupController {
    private final StudyGroupJdbc studyGroupJdbc;

    public StudyGroupController(StudyGroupJdbc studyGroupJdbc) {
        this.studyGroupJdbc = studyGroupJdbc;
    }

    @GetMapping("/study-group/{id}")
    public StudyGroup studyGroupById(@PathVariable(value = "id") int id) {
        return studyGroupJdbc.get(id);
    }

    @GetMapping("/study-group")
    public List<StudyGroup> studyGroupAll() {
        return studyGroupJdbc.getAll();
    }

    @PostMapping("/study-group")
    public int createStudyGroup(@RequestBody StudyGroup studyGroup) {
        return studyGroupJdbc.create(studyGroup);
    }

    @PutMapping("/study-group")
    public int updateStudyGroup(@RequestBody StudyGroup studyGroup) {
        return studyGroupJdbc.update(studyGroup);
    }

    @DeleteMapping("/study-group/{id}")
    public int deleteStudyGroup(@PathVariable(value = "id") int id) {
        return studyGroupJdbc.delete(id);
    }
}
