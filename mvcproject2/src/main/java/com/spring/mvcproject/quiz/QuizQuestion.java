package com.spring.mvcproject.quiz;

public class QuizQuestion {
    private int questionNum;
    private String questionContent;
    private String questionAnswer;

    public QuizQuestion(int questionNum, String questionContent, String questionAnswer) {
        this.questionNum = questionNum;
        this.questionContent = questionContent;
        this.questionAnswer = questionAnswer;
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}