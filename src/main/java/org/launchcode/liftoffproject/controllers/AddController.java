package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.*;
import org.launchcode.liftoffproject.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("add")
public class AddController {

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String displayAddInterventionForm(Model model, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));

        if (authenticationController.isUserLoggedIn(request)) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute(new Intervention());
            model.addAttribute("domains", domainRepository.findAll());
            model.addAttribute("tags", tagRepository.findAll());
            User user = new User();
            model.addAttribute("username", user.getUsername());
            model.addAttribute(user);

            return "add";
        }
        return "redirect:";
    }

    @PostMapping("")
    public String processAddInterventionForm(@ModelAttribute @Valid Intervention newIntervention, Errors errors, Model model, @RequestParam(required = false) List<Integer> domains, @RequestParam(required = false) List<Integer> tag, HttpServletRequest request) throws IOException {
        User user = authenticationController.getUserFromSession(request.getSession());
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));

        if (domains == null || domains.size() == 0 || domains.isEmpty()) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute("domains", domainRepository.findAll());
            model.addAttribute("tags", tagRepository.findAll());
            String str = "A Domain must be selected.";
            model.addAttribute("checkBoxError", str);
            return "add";
        }

        if (tag == null || tag.size() == 0 || tag.isEmpty()) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute("domains", domainRepository.findAll());
            model.addAttribute("tags", tagRepository.findAll());
            String str = "A Tag must be selected.";
            model.addAttribute("checkBoxErrorTag", str);
            return "add";
        }

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute("domains", domainRepository.findAll());
            model.addAttribute("tags", tagRepository.findAll());
            model.addAttribute("user", userRepository.findAll());
            return "add";
        }

        if (!HelperMethods.wordFilter(newIntervention.getName())) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute("domains", domainRepository.findAll());
            model.addAttribute("tags", tagRepository.findAll());
            String str = "That is an inappropriate choice of vocabulary.";
            model.addAttribute("nameBadWord", str);
            return "add";
        }

        if (!HelperMethods.wordFilter(newIntervention.getAction())) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute("domains", domainRepository.findAll());
            model.addAttribute("tags", tagRepository.findAll());
            String str = "That is an inappropriate choice of vocabulary.";
            model.addAttribute("actionBadWord", str);
            return "add";
        }

        if (!HelperMethods.wordFilter(newIntervention.getExpectedResponse())) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute("domains", domainRepository.findAll());
            model.addAttribute("tags", tagRepository.findAll());
            String str = "That is an inappropriate choice of vocabulary.";
            model.addAttribute("expectedResponseBadWord", str);
            return "add";
        }

        if (!HelperMethods.wordFilter(newIntervention.getReference())) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute("domains", domainRepository.findAll());
            model.addAttribute("tags", tagRepository.findAll());
            String str = "That is an inappropriate choice of vocabulary.";
            model.addAttribute("referenceBadWord", str);
            return "add";
        }

        if (!HelperMethods.wordFilter(newIntervention.getIfItFails())) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute("domains", domainRepository.findAll());
            model.addAttribute("tags", tagRepository.findAll());
            String str = "That is an inappropriate choice of vocabulary.";
            model.addAttribute("ifItFailsBadWord", str);
            return "add";
        }

        List<Domain> domainObjs = (List<Domain>) domainRepository.findAllById(domains);
        List<Tag> tagObjs = (List<Tag>) tagRepository.findAllById(tag);

        newIntervention.setUser(user);
        newIntervention.setDomains(domainObjs);
        newIntervention.setTags(tagObjs);

        interventionRepository.save(newIntervention);

        return "redirect:/profile";
    }

}
