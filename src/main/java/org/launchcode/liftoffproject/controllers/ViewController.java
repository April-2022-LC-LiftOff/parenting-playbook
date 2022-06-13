package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.CommentRepository;
import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.models.Comment;
import org.launchcode.liftoffproject.models.HelperMethods;
import org.launchcode.liftoffproject.models.Intervention;
import org.launchcode.liftoffproject.models.User;
import org.launchcode.liftoffproject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ViewController {

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private CommentService commentService;

    @GetMapping("view/{interventionId}/page/{pageNum}")

    public String displayViewIntervention(Model model, @PathVariable int interventionId, @PathVariable int pageNum, HttpServletRequest request) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            Boolean detectReferenceURL = HelperMethods.detectURL(intervention.getReference());
            Boolean detectIfItFailsURL = HelperMethods.detectURL(intervention.getIfItFails());

            model.addAttribute("intervention", intervention);
            model.addAttribute("detectReferenceURL", detectReferenceURL);
            if (detectReferenceURL) {
                String clickableReferenceURL = HelperMethods.clickableURL(intervention.getReference());
                model.addAttribute("clickableReferenceURL", clickableReferenceURL);
            }

            model.addAttribute("detectIfItFailsURL", detectIfItFailsURL);
            if (detectIfItFailsURL) {
                String clickableIfItFailsURL = HelperMethods.clickableURL(intervention.getIfItFails());
                model.addAttribute("clickableIfItFailsURL", clickableIfItFailsURL);
            }

            User user = authenticationController.getUserFromSession(request.getSession());
            model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
            Comment comment = new Comment();

            Page<Comment> page = commentService.getInterventionComments(interventionId, pageNum, "id", "Desc");
            List<Comment> listComments = page.getContent();
            model.addAttribute("comments", listComments);
            model.addAttribute("currentPage", pageNum);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalItems", page.getTotalElements());

            if (user != null) {
//                model.addAttribute("comments",
//                        commentRepository.findCommentByInterventionIdAndUserId(interventionId, user.getId()));
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

    @GetMapping("view/{interventionId}")
    public String displayInitialIntervention(Model model, @PathVariable int interventionId, HttpServletRequest request) {
        return displayViewIntervention(model, interventionId, 1, request);
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

    @PostMapping("view/{interventionId}/page/{pageNum}")
    public String processAddCommentFromPage(@ModelAttribute @Valid Comment newComment, Errors errors, Model model,
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
        return displayViewIntervention(model, interventionId, 1, request);
    }
}
