package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.DomainRepository;
import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.models.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("domains")
public class DomainsController {

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @GetMapping
    public String displayAllDomains(Model model, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));

        model.addAttribute("title", "All Domains");
        model.addAttribute("domains", domainRepository.findAll());

        return "domains/index";
    }

    @GetMapping("view/{domainId}")
    public String displayViewDomain(Model model, @PathVariable int domainId, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));

        Optional optDomain = domainRepository.findById(domainId);
        if (optDomain.isPresent()) {
            Domain domain = (Domain) optDomain.get();
            model.addAttribute("domain", domain);
            model.addAttribute("interventions", interventionRepository.findById(domainId));
            return "domains/view";
        } else {
            return "redirect:../";
        }
    }
}
