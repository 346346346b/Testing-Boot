package ru.ilyafilim.testing.services;

public interface DialogService {

    String MESSAGE_HELLO = "hello.user";
    String MESSAGE_ENTER_SURNAME = "enter.surname";
    String MESSAGE_LETS_TEST = "lets.test";
    String MESSAGE_YET_QUESTION = "yet.question";
    String MESSAGE_GET_QUESTION = "get.question";
    String MESSAGE_GET_RIGHT = "get.right";
    String MESSAGE_GET_WRONG = "get.wrong";
    String MESSAGE_NEXT_QUESTION = "next.question";
    String MESSAGE_FINAL_QUESTION = "final.question";
    String MESSAGE_END_OF_TEST = "end.of.test";

    String getDialogContent(String dialog, String[] params);
}
