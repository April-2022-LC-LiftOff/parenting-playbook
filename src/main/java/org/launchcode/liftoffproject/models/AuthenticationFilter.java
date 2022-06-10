package org.launchcode.liftoffproject.models;

import org.launchcode.liftoffproject.controllers.AuthenticationController;
import org.launchcode.liftoffproject.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter implements HandlerInterceptor {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    private static final List<String> blacklist = Arrays.asList("/add");

    private static boolean isNotBlacklisted(String path) {
        for (String pathRoot : blacklist)  {
            if (!path.startsWith (pathRoot)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {


        // Don't require sign-in for whitelisted pages
        if (isNotBlacklisted(request.getRequestURI())) {
            // returning true indicates that the request may proceed
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        if (user != null) {

            return true;
        }

//        // The user is NOT logged in
        FlashMap flashMap = new FlashMap();
        flashMap.put("mustlogin", "Please log in to access this feature.");
        FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);
        flashMapManager.saveOutputFlashMap(flashMap, request, response);
        response.sendRedirect("/login");
        return false;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        if (user != null) {
            modelAndView.addObject("user", user);
        }
    }

}
