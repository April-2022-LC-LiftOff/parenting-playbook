package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.CommentRepository;
import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.data.UserRepository;
import org.launchcode.liftoffproject.models.Comment;
import org.launchcode.liftoffproject.models.User;
import org.launchcode.liftoffproject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
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

    @Autowired
    CommentService commentService;

    @GetMapping
    @RequestMapping("profile/page/{pageNum}")
    public String profile(Model model, @PathVariable int pageNum, HttpSession session, RedirectAttributes redirAttrs, HttpServletRequest request) {
        User user = authenticationController.getUserFromSession(session);
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));

        if (user == null) {
            redirAttrs.addFlashAttribute("mustlogin", "Please log into access this feature.");

            return "redirect:login";
        }

        Page<Comment> page = commentService.getUserComments(user.getId(), pageNum, "id", "Desc");
        List<Comment> listComments = page.getContent();
        model.addAttribute("comments", listComments);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());



        model.addAttribute("title", user.getUsername());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        model.addAttribute("email", user.getEmail());
//        model.addAttribute("comments", user.getComments());
        model.addAttribute(user);

        return "profile";
    }

    @GetMapping("profile")
    public String displayInitialProfile(Model model, HttpSession session, RedirectAttributes redirAttrs, HttpServletRequest request) {
        return profile(model, 1,session, redirAttrs, request);
    }

    @GetMapping("/editComment/{commentId}")
    public String editCommentForm(Model model, @PathVariable int commentId, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
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
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
        Optional optComment = commentRepository.findById(commentId);
        Comment comment = (Comment) optComment.get();

        comment.setUserInput(userInput);
        commentRepository.save(comment);
        return "redirect:/profile";
    }

    @RequestMapping("/delete/{id}")
    public String deleteComment(Model model, @PathVariable(name = "id") int id, HttpServletRequest request) {
        model.addAttribute("loggedIn", authenticationController.isUserLoggedIn(request));
        commentRepository.deleteById(id);
        return "redirect:/profile";
    }



}
