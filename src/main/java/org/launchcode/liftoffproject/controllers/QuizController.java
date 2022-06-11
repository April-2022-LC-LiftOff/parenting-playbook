package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.DomainRepository;
import org.launchcode.liftoffproject.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private AuthenticationController authenticationController;

    List<String> quizResults = new ArrayList<>();

    @GetMapping("quiz")
    public String displayAllQuestions(Model model, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
        List<String> questionnaire = new ArrayList<>();
        model.addAttribute("questionnaire", questionnaire);
        return "quiz";
    }

    @GetMapping("results")
    public String getResults(Model model, Quiz quiz, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
        model.addAttribute("Quiz", quiz);
        return "results";
    }

    @PostMapping("results")
    public String processFormMethodQuiz(@ModelAttribute("quiz") @Valid Quiz quiz, Model model, @RequestParam(required = false)
            List<String> impulseControl, @RequestParam(required = false) List<String> emotionalControl, @RequestParam(required = false)
                                                List<String> flexibleThinking, @RequestParam(required = false)
                                                List<String> workingMemory, @RequestParam(required = false)
                                                List<String> selfMonitoring, @RequestParam(required = false)
                                                List<String> planningAndPrioritizing, @RequestParam(required = false)
                                                List<String> taskInitiation, @RequestParam(required = false)
                                                List<String> organization, @RequestParam(required = false) List<String> none, HttpServletRequest request) {

        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));

        if (impulseControl == null || impulseControl.size() < 2) {
            model.addAttribute("title", quiz);
        } else if (impulseControl.size() >= 2) {
            model.addAttribute("impulseControl", domainRepository.findById(1));
        }

        if (emotionalControl == null || emotionalControl.size() < 2) {
            model.addAttribute("title", quiz);
        } else if (emotionalControl.size() >= 2) {
            model.addAttribute("emotionalControl", domainRepository.findById(2));
        }

        if (flexibleThinking == null || flexibleThinking.size() < 2) {
            model.addAttribute("title", quiz);
        } else if (flexibleThinking.size() >= 2) {
            model.addAttribute("flexibleThinking", domainRepository.findById(3));
        }

        if (workingMemory == null || workingMemory.size() < 2) {
            model.addAttribute("title", quiz);
        } else if (workingMemory.size() >= 2) {
            model.addAttribute("workingMemory", domainRepository.findById(4));
        }

        if (selfMonitoring == null || selfMonitoring.size() < 2) {
            model.addAttribute("title", quiz);
        } else if (selfMonitoring.size() >= 2) {
            model.addAttribute("selfMonitoring", domainRepository.findById(5));
        }

        if (planningAndPrioritizing == null || planningAndPrioritizing.size() < 2) {
            model.addAttribute("title", quiz);
        } else if (planningAndPrioritizing.size() >= 2) {
            model.addAttribute("planningAndPrioritizing", domainRepository.findById(6));
        }

        if (taskInitiation == null || taskInitiation.size() < 2) {
            model.addAttribute("title", quiz);
        } else if (taskInitiation.size() >= 2) {
            model.addAttribute("taskInitiation", domainRepository.findById(7));
        }

        if (organization == null || organization.size() < 2) {
            model.addAttribute("title", quiz);
        } else if (organization.size() >= 2) {
            model.addAttribute("organization", domainRepository.findById(8));
        }

        if ((impulseControl == null || impulseControl.size() < 2) && (emotionalControl == null || emotionalControl.size() < 2)
                && (flexibleThinking == null || flexibleThinking.size() < 2) && (workingMemory == null || workingMemory.size() < 2)
                && (selfMonitoring == null || selfMonitoring.size() < 2) && (planningAndPrioritizing == null || planningAndPrioritizing.size() < 2)
                && (taskInitiation == null || taskInitiation.size() < 2) && (organization == null || organization.size() < 2)) {
            model.addAttribute("title", quiz);
            model.addAttribute("none", domainRepository.findAll());

        }
        return "results";
    }
}
