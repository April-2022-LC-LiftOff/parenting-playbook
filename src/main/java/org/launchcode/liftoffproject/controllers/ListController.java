package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.DomainRepository;
import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.models.Intervention;
import org.launchcode.liftoffproject.models.InterventionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private InterventionRepository interventionRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController() {
        columnChoices.put("all", "All");
        columnChoices.put("domains", "Domains");
        columnChoices.put("interventions", "Interventions");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("domains", domainRepository.findAll());
        model.addAttribute("interventions", interventionRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "interventions")
    public String listInterventionsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Intervention> interventions;
        if (column.toLowerCase(Locale.ROOT).equals("all")) {
            interventions = interventionRepository.findAll();
            model.addAttribute("title", "All Interventions");
        } else {
            interventions = InterventionData.findByColumnAndValue(column, value, interventionRepository.findAll());
            model.addAttribute("title", "Interventions with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("interventions", interventions);

        return "list-interventions";
    }
}