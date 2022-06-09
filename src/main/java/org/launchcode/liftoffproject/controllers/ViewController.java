package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.CommentRepository;
import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.models.Comment;
import org.launchcode.liftoffproject.models.HelperMethods;
import org.launchcode.liftoffproject.models.Intervention;
import org.launchcode.liftoffproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ViewController {

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @GetMapping("view/{interventionId}")
    public String displayViewIntervention(Model model, @PathVariable int interventionId, HttpServletRequest request) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);
            model.addAttribute("detectURL", HelperMethods.detectURL(intervention.getReference()));
            if (HelperMethods.detectURL(intervention.getReference())) {
                String clickableURL = HelperMethods.clickableURL(intervention.getReference());
                model.addAttribute("clickableURL", clickableURL);
            }

            User user = authenticationController.getUserFromSession(request.getSession());
            model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
            Comment comment = new Comment();

            if (user != null) {
                model.addAttribute("comments", commentRepository.findCommentByInterventionIdAndUserId(interventionId, user.getId()));
                if (user == intervention.getUser()) {
                    model.addAttribute("initialUser", true);
                }
            }

            model.addAttribute("comment", comment);
            model.addAttribute("user", user);

            return "view";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("view/{interventionId}")
    public String processAddComment(@ModelAttribute @Valid Comment newComment, Errors errors, Model model,
                                    @PathVariable int interventionId, HttpServletRequest request) {
        User user = authenticationController.getUserFromSession(request.getSession());
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));

        Optional optIntervention = interventionRepository.findById(interventionId);
        Intervention intervention = (Intervention) optIntervention.get();
        if (errors.hasErrors()) {
            model.addAttribute("intervention", intervention);
            return "view";
        }

        newComment.setUser(user);
        newComment.setIntervention(intervention);
        commentRepository.save(newComment);
        return "redirect:{interventionId}";
    }
}
