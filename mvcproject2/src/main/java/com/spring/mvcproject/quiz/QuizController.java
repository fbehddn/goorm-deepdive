package com.spring.mvcproject.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {

    private final QuizSession quizSession;
    private final QuizQuestion[] questions = {
            new QuizQuestion(1, "What is my favorite color", "blue"),
            new QuizQuestion(2, "What is my name?", "Tom"),
            new QuizQuestion(3, "What is my favorite food?", "fruit")
    };

    @Autowired
    public QuizController(QuizSession quizSession) {
        this.quizSession = quizSession;
    }

    // 퀴즈 시작 (첫 페이지)
    @GetMapping("/quiz")
    public String startQuiz(Model model) {
        quizSession.reset();
        model.addAttribute("question", questions[quizSession.getNumber()]);
        return "quiz";
    }

    // 퀴즈 제출 (정답 확인)
    @PostMapping("/quiz")
    public String submitAnswer(@RequestParam String answer, Model model) {
        QuizQuestion currentQuestion = questions[quizSession.getNumber()];

        if (currentQuestion.getQuestionAnswer().equalsIgnoreCase(answer)) {
            quizSession.incrementScore();
        }

        quizSession.setNumber(quizSession.getNumber() + 1);

        if (quizSession.getNumber() < questions.length) {
            model.addAttribute("question", questions[quizSession.getNumber()]);
            return "quiz";
        } else {
            return "redirect:/quiz-result";
        }
    }

    // 퀴즈 결과
    @GetMapping("/quiz-result")
    public String quizResult(Model model) {
        model.addAttribute("score", quizSession.getScore());
        model.addAttribute("total", questions.length);
        return "quiz-result";
    }
}