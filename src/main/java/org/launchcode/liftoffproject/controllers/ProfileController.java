package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.CommentRepository;
import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.data.UserRepository;
import org.launchcode.liftoffproject.models.Comment;
import org.launchcode.liftoffproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    AuthenticationController authenticationController;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    InterventionRepository interventionRepository;

    @GetMapping
    @RequestMapping("profile")
    public String profile(Model model, HttpSession session, RedirectAttributes redirAttrs) {
        User user = authenticationController.getUserFromSession(session);
        if (user == null) {
            model.addAttribute("loggedIn", false);
        } else if (user != null) {
            model.addAttribute("loggedIn", true);
        }

        if (user == null) {
            redirAttrs.addFlashAttribute("mustlogin", "Please log into access this feature.");

            return "redirect:login";
        }

        model.addAttribute("title", user.getUsername());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("comments", user.getComments());
        model.addAttribute(user);

        return "profile";
    }

    @GetMapping("/editComment/{commentId}")
    public String editCommentForm(Model model, @PathVariable int commentId, HttpServletRequest request) {
        User user = authenticationController.getUserFromSession(request.getSession());

        if (user == null) {
            model.addAttribute("loggedIn", false);
        } else if (user != null) {
            model.addAttribute("loggedIn", true);
        }
        Optional optComment = commentRepository.findById(commentId);
        if (optComment.isPresent()) {
            Comment comment = (Comment) optComment.get();
            model.addAttribute("comment", comment);
            return "editComment";
        } else {
            return "redirect:profile";
        }
    }

    @PostMapping("/editComment/{commentId}")
    public String saveComment(Model model, @PathVariable int commentId, @RequestParam String userInput, HttpServletRequest request) {
        User user = authenticationController.getUserFromSession(request.getSession());

        if (user == null) {
            model.addAttribute("loggedIn", false);
        } else if (user != null) {
            model.addAttribute("loggedIn", true);
        }
        Optional optComment = commentRepository.findById(commentId);
        Comment comment = (Comment) optComment.get();

        comment.setUserInput(userInput);
        commentRepository.save(comment);
        return "redirect:/profile";
    }

    @RequestMapping("/delete/{id}")
    public String deleteComment(Model model, @PathVariable(name = "id") int id, HttpServletRequest request) {
        User user = authenticationController.getUserFromSession(request.getSession());

        if (user == null) {
            model.addAttribute("loggedIn", false);
        } else if (user != null) {
            model.addAttribute("loggedIn", true);
        }
        commentRepository.deleteById(id);
        return "redirect:/profile";
    }



}
