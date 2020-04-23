package ru.ilyafilim.testing.services;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleDialogServiceImpl implements ConsoleDialogService {

    Scanner in = new Scanner(System.in);

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void printLn() {
        System.out.println();
    }

    @Override
    public String readRow() {
        return in.nextLine();
    }
}
