package org.launchcode.liftoffproject.models;

import org.launchcode.liftoffproject.controllers.AuthenticationController;
import org.launchcode.liftoffproject.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    private static final List<String> whitelist = Arrays.asList("/login","/register","/logout", "/css", "/js/bootstrap");

    private static boolean isWhitelisted(String path){
        for (String pathRoot: whitelist){
            if(path.startsWith(pathRoot)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {
        if (isWhitelisted(request.getRequestURI())){
            return true;
        }
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        if(user!=null){
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }
}