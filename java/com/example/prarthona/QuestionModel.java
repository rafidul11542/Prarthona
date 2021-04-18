package com.example.prarthona;

public class QuestionModel {
    String id, question;

    public QuestionModel()
    {

    }

    public QuestionModel(String id, String question) {
        this.id = id;
        this.question = question;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }
}
