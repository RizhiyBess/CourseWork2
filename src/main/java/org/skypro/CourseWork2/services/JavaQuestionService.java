package org.skypro.CourseWork2.services;
import org.skypro.CourseWork2.entities.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions = new ArrayList<>();

    @Override
    public List<Question> getAll() {
        return questions;
    }

    @Override
    public boolean addQuestion(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeQuestionByContent(String question, String answer) {
        for (Question q : questions) {
            if (q.getQuestion().equals(question) && q.getAnswer().equals(answer)) {
                questions.remove(q);
                return true;
            }
        }
        return false;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException("Нет ни одного вопроса");
        }
        int randomIndex = new Random().nextInt(questions.size());
        return questions.get(randomIndex);
    }
}