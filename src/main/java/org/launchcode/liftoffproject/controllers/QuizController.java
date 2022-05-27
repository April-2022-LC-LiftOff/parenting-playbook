package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private DomainRepository domainRepository;

    static HashMap<String, String> questionnaire = new HashMap<>();


    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("domains", domainRepository.findAll());
        model.addAttribute("domains", domainRepository.findAll());
        return "quiz";
    }



}


