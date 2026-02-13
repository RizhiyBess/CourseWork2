package org.skypro.CourseWork2.services;
import org.skypro.CourseWork2.entities.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public List<Question> getQuestions(int count) {
        List<Question> allQuestions = javaQuestionService.getAll();
        Set<Integer> usedIndexes = new HashSet<>();
        List<Question> result = new LinkedList<>();

        if (count > allQuestions.size()) {
            throw new IllegalArgumentException("Запрашиваемое количество вопросов превышает доступное.");
        }

        while (result.size() < count) {
            int index = new Random().nextInt(allQuestions.size());

            if (!usedIndexes.contains(index)) {
                result.add(allQuestions.get(index));
                usedIndexes.add(index);
            }
        }
        return result;
    }
}
