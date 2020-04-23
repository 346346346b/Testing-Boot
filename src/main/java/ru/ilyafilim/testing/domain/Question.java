package ru.ilyafilim.testing.domain;

public class Question {


    private final String term;
    private final String definition;

    public Question(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }
}
