package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.models.Intervention;
import org.launchcode.liftoffproject.models.InterventionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

import static org.launchcode.liftoffproject.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @RequestMapping("")
    public String search(Model model, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
        Iterable<Intervention> interventions;
        if (searchTerm.toLowerCase(Locale.ROOT).equals("all") || searchTerm.equals("")) {
            interventions = interventionRepository.findAll();
        } else {
            interventions = InterventionData.findByColumnAndValue(searchType, searchTerm, interventionRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Strategies with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("interventions", interventions);

        return "search";
    }
}
