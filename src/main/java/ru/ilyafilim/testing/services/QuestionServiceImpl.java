package ru.ilyafilim.testing.services;

import org.springframework.stereotype.Service;
import ru.ilyafilim.testing.dao.QuestionDao;
import ru.ilyafilim.testing.domain.Question;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;
    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public Question getNextQuestion() {
        return dao.readRow();
    }
}
