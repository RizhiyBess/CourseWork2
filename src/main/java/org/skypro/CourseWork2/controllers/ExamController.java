package org.skypro.CourseWork2.controllers;

import org.skypro.CourseWork2.entities.Question;
import org.skypro.CourseWork2.services.ExaminerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.skypro.CourseWork2.services.ExaminerService;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }

    @GetMapping("/get/{amount}")
    public List<Question> getQuestions(@PathVariable int amount) {
        try {
            return examinerServiceImpl.getQuestions(amount);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
