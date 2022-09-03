package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.models.Intervention;
import org.launchcode.liftoffproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class LikeController {

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @RequestMapping(value = "view/{interventionId}/page/{pageNum}/like")
    public String like(Model model, HttpServletRequest request, @PathVariable int interventionId) {
        User user = authenticationController.getUserFromSession(request.getSession());
        int userId = user.getId();
        Optional optIntervention = interventionRepository.findById(interventionId);
        Intervention intervention = (Intervention) optIntervention.get();
        List<Integer> likes = intervention.getLike();

        if (likes.contains(userId)) {
            likes.remove(userId);
            intervention.setLike(likes);
            interventionRepository.save(intervention);
        } else {
            likes.add(userId);
            intervention.setLike(likes);
            interventionRepository.save(intervention);
        }

        return "redirect:";
    }
}
