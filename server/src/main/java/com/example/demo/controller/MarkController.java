package com.example.demo.controller;

import com.example.demo.dao.MarkJdbc;
import com.example.demo.model.Mark;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mark")
public class MarkController {

    private final MarkJdbc markJdbc;

    public MarkController(MarkJdbc markJdbc) {
        this.markJdbc = markJdbc;
    }

    @GetMapping("/{id}")
    public Mark getMark(@PathVariable int id) {
        Mark mark = markJdbc.get(id);
        return mark;
    }
}