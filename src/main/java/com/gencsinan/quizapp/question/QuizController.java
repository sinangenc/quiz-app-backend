package com.gencsinan.quizapp.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {
    private QuizRepository quizRepository;

    @Autowired
    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @GetMapping("/test/{state}")
    public ResponseEntity<List<QuestionWithoutCorrectAnswerDTO>> getARandomTest(@PathVariable String state) {
        // A test contains 33 questions
        // 30 general questions + 3 state-specific questions
        List<Question> questions = quizRepository.findRandomGeneralQuestions(30);
        List<Question> state_questions = quizRepository.findRandomQuestionsByState(3, state);
        questions.addAll(state_questions);

        // Remove correct answer and unnecessary fields using DTO
        List<QuestionWithoutCorrectAnswerDTO> questionWithoutCorrectAnswers = questions.stream()
                .map(QuizQuestionMapper::questionMapper)
                .toList();

        return ResponseEntity.ok(questionWithoutCorrectAnswers);
    }

    @GetMapping("/training")
    public ResponseEntity<Question> getRandomQuestion() {
        return ResponseEntity.notFound().build();
    }
}