package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.data.TagRepository;
import org.launchcode.liftoffproject.models.Tag;
import org.launchcode.liftoffproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @GetMapping
    public String displayAllTags(Model model, HttpServletRequest request) {
        User user = authenticationController.getUserFromSession(request.getSession());

        if (user == null) {
            model.addAttribute("loggedIn", false);
        } else if (user != null) {
            model.addAttribute("loggedIn", true);
        }

        model.addAttribute("title", "All Tags");
        model.addAttribute("tags", tagRepository.findAll());

        return "tags/index";
    }

    @GetMapping("add")
    public String displayAddTagForm(Model model, HttpServletRequest request) {
        User user = authenticationController.getUserFromSession(request.getSession());

        if (user == null) {
            model.addAttribute("loggedIn", false);
        } else if (user != null) {
            model.addAttribute("loggedIn", true);
        }

        model.addAttribute(new Tag());

        return "tags/add";
    }

    @PostMapping("add")
    public String processAddTagForm(@ModelAttribute @Valid Tag newTag, Errors errors, Model model, HttpServletRequest request) {
        User user = authenticationController.getUserFromSession(request.getSession());

        if (user == null) {
            model.addAttribute("loggedIn", false);
        } else if (user != null) {
            model.addAttribute("loggedIn", true);
        }

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Tag");
            return "tags/add";
        }

        tagRepository.save(newTag);

        return "redirect:";
    }

    @GetMapping("view/{tagId}")
    public String displayViewTag(Model model, @PathVariable int tagId, HttpServletRequest request) {
        User user = authenticationController.getUserFromSession(request.getSession());

        if (user == null) {
            model.addAttribute("loggedIn", false);
        } else if (user != null) {
            model.addAttribute("loggedIn", true);
        }
        Optional optTag = tagRepository.findById(tagId);
        if(optTag.isPresent()) {
            Tag tag = (Tag) optTag.get();
            model.addAttribute("tag", tag);
            model.addAttribute("interventions", interventionRepository.findById(tagId));
            return "tags/view";
        }

        return "redirect:../";
    }
}
