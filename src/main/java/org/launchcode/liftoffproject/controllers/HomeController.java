package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.CommentRepository;
import org.launchcode.liftoffproject.data.DomainRepository;
import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.models.Domain;
import org.launchcode.liftoffproject.models.Intervention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private CommentRepository commentRepository;


    public void createDomains() {
        String[] domains = {"Impulse Control", "Emotional Control", "Flexible Thinking", "Working Memory", "Self-Monitoring", "Planning and Prioritizing", "Task Iniation", "Organization"};
        String[] descriptions = {"Think before acting", "Keep feelings in check", "Adjust behavior to unexpected changes", "Keep key information in mind while using it", "Self-awareness to how one id doing in the moment", "To set and meet goals", "Take action to get started on tasks", "Keep track of things physically and mentally"};

        for (int i = 0; i < domains.length; i++) {
            Optional<Domain> result = domainRepository.findById(i + 1);
            if (result.isEmpty()) {
                Domain domain = new Domain(domains[i], descriptions[i]);
                domainRepository.save(domain);
            }
        }
    }

    @RequestMapping("")
    public String index(Model model) {
        createDomains();

        model.addAttribute("title", "My Interventions");
        model.addAttribute("interventions", interventionRepository.findAll());

        return "index";
    }

    @GetMapping("add")
    public String displayAddInterventionForm(Model model) {
        model.addAttribute("title", "Add Intervention");
        model.addAttribute(new Intervention());
        model.addAttribute("domains", domainRepository.findAll());

        return "add";
    }

    @PostMapping("add")
    public String processAddInterventionForm(@ModelAttribute @Valid Intervention newIntervention, Errors errors, Model model, @RequestParam List<Integer> domains) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Intervention");
            return "add";
        }

        List<Domain> domainObjs = (List<Domain>) domainRepository.findAllById(domains);
        newIntervention.setDomains(domainObjs);

        interventionRepository.save(newIntervention);

        return "redirect:";
    }

//    @PostMapping("add")
//    public String processAddInterventionForm(@ModelAttribute @Valid Intervention newIntervention, Errors errors, Model model, @RequestParam(required = false) List<Integer> domains) {
//        if (domains == null || domains.size() == 0 || domains.isEmpty()) {
//            model.addAttribute("title", "Add Intervention");
//            model.addAttribute("domains", domainRepository.findAll());
//            String str = "A Domain must be selected.";
//            model.addAttribute("checkBoxError", str);
//            return "add";
//        }
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Intervention");
//            model.addAttribute("domains", domainRepository.findAll());
//            return "add";
//        }
//
//        List<Domain> domainObjs = (List<Domain>) domainRepository.findAllById(domains);
//        newIntervention.setDomains(domainObjs);
//
//        interventionRepository.save(newIntervention);
//
//        return "redirect:";
//    }



    @GetMapping("view/{interventionId}")
    public String displayViewIntervention(Model model, @PathVariable int interventionId) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);

            model.addAttribute("addComment", "addComment");
            return "view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("about")
    public String displayAbout() {
        return "about";
    }
}
