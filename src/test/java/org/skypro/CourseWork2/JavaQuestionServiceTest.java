package org.skypro.CourseWork2;

import org.skypro.CourseWork2.entities.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.CourseWork2.services.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaQuestionServiceTest {

    private JavaQuestionService service;

    @BeforeEach
    void setup() {
        service = new JavaQuestionService();
    }

    @Test
    void testAddAndRemoveQuestion() {
        assertTrue(service.addQuestion(new Question("Что такое OOP?", "Объектно-ориентированное программирование")));
        assertFalse(service.addQuestion(new Question("Что такое OOP?", "Объектно-ориентированное программирование")));
        assertTrue(service.removeQuestionByContent("Что такое OOP?", "Объектно-ориентированное программирование"));
    }

    @Test
    void testGetRandomQuestion() {
        service.addQuestion(new Question("Что такое JVM?", "Java Virtual Machine"));
        service.addQuestion(new Question("Что такое интерфейс?", "Абстрактный тип данных"));
        Question randomQuestion = service.getRandomQuestion();
        assertTrue(service.getAll().contains(randomQuestion));
    }
}
