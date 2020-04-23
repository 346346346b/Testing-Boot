package ru.ilyafilim.testing.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ilyafilim.testing.config.TestingSettings;
import ru.ilyafilim.testing.domain.Question;

@Service
public class GameServiceImp implements GameService {

    private final DialogService dialog;
    private final QuestionService questionService;
    private final ConsoleDialogService console;
    private final int MAX_QUESTION;

    public GameServiceImp(DialogService dialog, QuestionService questionService, ConsoleDialogService console, @Qualifier("testingSettings") TestingSettings settings) {
        this.dialog = dialog;
        this.questionService = questionService;
        this.console = console;
        this.MAX_QUESTION = settings.getQuestions();
    }

    @Override
    public void game() {
        console.print(dialog.getDialogContent(DialogService.MESSAGE_HELLO, new String[]{}));
        String name = console.readRow();
        console.print(dialog.getDialogContent(DialogService.MESSAGE_ENTER_SURNAME, new String[]{name}));
        String surname = console.readRow();
        console.print(dialog.getDialogContent(DialogService.MESSAGE_LETS_TEST, new String[]{}));
        Question question; int c = 0;
        for (int a = 0; a != MAX_QUESTION; a++) {
            question = questionService.getNextQuestion();
            console.printLn();
            console.print(dialog.getDialogContent(DialogService.MESSAGE_YET_QUESTION, new String[]{String.valueOf(a+1), question.getDefinition()}));
            console.printLn();
            console.print(dialog.getDialogContent(DialogService.MESSAGE_GET_QUESTION, new String[]{}));
            String ans = console.readRow();
            if (ans.equalsIgnoreCase(question.getTerm())) {
                c++;
                console.print(dialog.getDialogContent(DialogService.MESSAGE_GET_RIGHT, new String[]{}));
            } else {
                console.print(dialog.getDialogContent(DialogService.MESSAGE_GET_WRONG, new String[]{question.getTerm()}));
            }
            if (MAX_QUESTION - a == 2) {
                console.print(dialog.getDialogContent(DialogService.MESSAGE_FINAL_QUESTION, new String[]{}));
            } else if (MAX_QUESTION - a > 2){
                console.print(dialog.getDialogContent(DialogService.MESSAGE_NEXT_QUESTION, new String[]{}));
            }
        }
        console.printLn();
        console.print(dialog.getDialogContent(DialogService.MESSAGE_END_OF_TEST, new String[]{name, surname, String.valueOf(c), String.valueOf(MAX_QUESTION)}));
    }
}
