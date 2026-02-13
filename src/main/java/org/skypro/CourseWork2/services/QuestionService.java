package org.skypro.CourseWork2.services;
import org.skypro.CourseWork2.entities.Question;
import java.util.List;

public interface QuestionService {
    List<Question> getAll();
    boolean addQuestion(Question question);
    boolean removeQuestionByContent(String question, String answer);
    Question getRandomQuestion();
}
