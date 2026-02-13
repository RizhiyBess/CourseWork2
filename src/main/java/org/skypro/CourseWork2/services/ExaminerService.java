package org.skypro.CourseWork2.services;
import org.skypro.CourseWork2.entities.Question;
import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int count);
}
