package org.skypro.CourseWork2.controllers;

import org.skypro.CourseWork2.entities.Question;
import org.springframework.web.bind.annotation.*;
import org.skypro.CourseWork2.services.JavaQuestionService;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService service;

    public JavaQuestionController(JavaQuestionService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Question> getAllQuestions() {
        return service.getAll();
    }

    @GetMapping("/add")
    public boolean addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.addQuestion(new Question(question, answer));
    }

    @GetMapping("/remove")
    public boolean deleteQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.removeQuestionByContent(question, answer);
    }
}
