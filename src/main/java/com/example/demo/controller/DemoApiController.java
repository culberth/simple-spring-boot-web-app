package com.example.demo.controller;

import com.example.demo.model.Submission;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoApiController {

    @PostMapping
    public Submission submit(@Valid @RequestBody Submission submission) {
        return submission;
    }
}
