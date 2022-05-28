package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private DomainRepository domainRepository;

    List<String> quizResults = new ArrayList<>();

    @GetMapping("quiz")
    public String displayAllQuestions(Model model) {
        List<String> questionnaire = new ArrayList<>();
        model.addAttribute("questionnaire", questionnaire);
        return "quiz";
    }

    @GetMapping("results")
    public String displayResults(Model model) {
        List<String> questionnaire = new ArrayList<>();
        model.addAttribute("questionnaire", questionnaire);
        return "results";
    }

    @PostMapping("results")
    public String processFormMethodQuiz(Model model, RequestParam domain)  {
        quizResults.add(String.valueOf(domain));
        model.addAttribute("quizResults", quizResults);
        model.addAttribute("domains", domainRepository.findAll());
        return "results";
    }



}


