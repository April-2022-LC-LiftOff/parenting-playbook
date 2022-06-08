package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.DomainRepository;
import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.data.TagRepository;
import org.launchcode.liftoffproject.models.Intervention;
import org.launchcode.liftoffproject.models.InterventionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private AuthenticationController authenticationController;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController() {
        columnChoices.put("all", "All");
        columnChoices.put("domain", "Domain");
        columnChoices.put("tag", "Tag");
    }

    @RequestMapping("")
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
        model.addAttribute("domains", domainRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "interventions")
    public String listInterventionsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
        Iterable<Intervention> interventions;
        if (column.toLowerCase(Locale.ROOT).equals("all")) {
            interventions = interventionRepository.findAll();
            model.addAttribute("title", "All Interventions");
        } else {
            interventions = InterventionData.findByColumnAndValue(column, value, interventionRepository.findAll());
            model.addAttribute("title", "Strategies in " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("interventions", interventions);

        return "list-interventions";
    }
}
