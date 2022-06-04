package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.UserRepository;
import org.launchcode.liftoffproject.models.User;
import org.launchcode.liftoffproject.models.dto.LoginFormDTO;
import org.launchcode.liftoffproject.models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        if (user == null) {
            model.addAttribute("loggedIn", false);
        } else if (user != null) {
            model.addAttribute("loggedIn", true);
        }
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Register");
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {
        User user = getUserFromSession(request.getSession());

        if (errors.hasErrors()) {
            if (user == null) {
                model.addAttribute("loggedIn", false);
            } else if (user != null) {
                model.addAttribute("loggedIn", true);
            }
            model.addAttribute("title", "Register");
            return "register";
        }

        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());

        if (existingUser != null) {
            if (user == null) {
                model.addAttribute("loggedIn", false);
            } else if (user != null) {
                model.addAttribute("loggedIn", true);
            }
            errors.rejectValue("username", "username.already exists", "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "register";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            if (user == null) {
                model.addAttribute("loggedIn", false);
            } else if (user != null) {
                model.addAttribute("loggedIn", true);
            }
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "register";
        }

        User newUser = new User(registerFormDTO.getFirstName(), registerFormDTO.getLastName(), registerFormDTO.getEmail(),
                                registerFormDTO.getUsername(), registerFormDTO.getPassword(), registerFormDTO.getVerifyPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }
    @GetMapping("/login")
    public String displayLoginForm(Model model, HttpServletRequest request) {
        User user = getUserFromSession(request.getSession());

        if (user == null) {
            model.addAttribute("loggedIn", false);
        } else if (user != null) {
            model.addAttribute("loggedIn", true);
        }

        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors, HttpServletRequest request, RedirectAttributes redirAttrs,
                                   Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            User user = getUserFromSession(request.getSession());

            if (user == null) {
                model.addAttribute("loggedIn", false);
            } else if (user != null) {
                model.addAttribute("loggedIn", true);
            }
            return "login";
        }

        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

        if (theUser == null) {
            User user = getUserFromSession(request.getSession());

            if (user == null) {
                model.addAttribute("loggedIn", false);
            } else if (user != null) {
                model.addAttribute("loggedIn", true);
            }
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            model.addAttribute("title", "Log In");
            return "login";
        }

        String password = loginFormDTO.getPassword();

        if (!theUser.isMatchingPassword(password)) {
            User user = getUserFromSession(request.getSession());

            if (user == null) {
                model.addAttribute("loggedIn", false);
            } else if (user != null) {
                model.addAttribute("loggedIn", true);
            }
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Log In");
            return "login";
        }

        setUserInSession(request.getSession(), theUser);
        User currentUser = getUserFromSession(request.getSession());
        redirAttrs.addFlashAttribute("hello", "Hello, " + currentUser.getFirstName());

        return "redirect:";
    }
    @GetMapping("/logout")
    public String logout(Model model, HttpServletRequest request,RedirectAttributes redirAttrs){
        User user = getUserFromSession(request.getSession());

        if (user == null) {
            model.addAttribute("loggedIn", false);
        } else if (user != null) {
            model.addAttribute("loggedIn", true);
        }
        redirAttrs.addFlashAttribute("logout", "You have logged out.");
        request.getSession().invalidate();
        return "redirect:/login";
    }

}
