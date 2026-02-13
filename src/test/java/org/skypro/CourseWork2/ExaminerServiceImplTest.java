package org.skypro.CourseWork2;

import org.skypro.CourseWork2.entities.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.CourseWork2.services.ExaminerServiceImpl;
import org.skypro.CourseWork2.services.JavaQuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExaminerServiceImplTest {

    private ExaminerServiceImpl examinerService;
    private JavaQuestionService questionService;

    @BeforeEach
    void setup() {
        questionService = new JavaQuestionService();
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void testGetUniqueQuestions() {
        questionService.addQuestion(new Question("Вопрос 1", "Ответ 1"));
        questionService.addQuestion(new Question("Вопрос 2", "Ответ 2"));
        List<Question> uniqueQuestions = examinerService.getQuestions(2);
        assertTrue(uniqueQuestions.size() == 2);
        assertTrue(uniqueQuestions.stream().allMatch(q -> !uniqueQuestions.subList(uniqueQuestions.indexOf(q)+1, uniqueQuestions.size()).contains(q)));
    }

    @Test
    void testBadRequestIfCountIsTooBig() {
        questionService.addQuestion(new Question("Вопрос 1", "Ответ 1"));
        assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(3));
    }
}
