package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.DomainRepository;
import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.data.TagRepository;
import org.launchcode.liftoffproject.models.HelperMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

@Controller
public class HomeController {

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @RequestMapping("")
    public String index(Model model, HttpServletRequest request) throws FileNotFoundException {
        HelperMethods.createDomains(domainRepository);
        HelperMethods.createTags(tagRepository);
        HelperMethods.saveInterventions(interventionRepository, domainRepository, tagRepository);

        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
        model.addAttribute("title", "All Domains");
        model.addAttribute("domains", domainRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());

        return "index";
    }

    @GetMapping("about")
    public String displayAbout(Model model, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
        return "about";
    }

    @GetMapping("faq")
    public String displayFaq(Model model, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
        return "faq";
    }

}