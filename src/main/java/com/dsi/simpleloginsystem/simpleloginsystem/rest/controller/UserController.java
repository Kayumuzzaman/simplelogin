package com.dsi.simpleloginsystem.simpleloginsystem.rest.controller;

import com.dsi.simpleloginsystem.simpleloginsystem.model.CurrentUser;
import com.dsi.simpleloginsystem.simpleloginsystem.rest.response.RestResponse;
import com.dsi.simpleloginsystem.simpleloginsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<Object> ping() {
        return RestResponse.generateResponse(HttpStatus.OK, true, "Login System is UP", "ping okay");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) {
        log.info("Loading login page...");
        model.addAttribute("currentUser", new CurrentUser());
        return "login";
    }

    @RequestMapping(value = "/login/user", method = RequestMethod.POST)
    public String validateUser(@ModelAttribute CurrentUser currentUser, HttpServletRequest request) {
        boolean check = userService.loginUser(currentUser);
        if (check) {
            request.getSession().setAttribute("currentUserEmail", currentUser.getUserEmail());
            return "redirect:/success";
        } else {
            request.getSession().setAttribute("currentUserEmail", null);
            return "redirect:/success";
        }
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(Model model, HttpServletRequest request) {
        String currentUserEmail = (String) request.getSession().getAttribute("currentUserEmail");
        model.addAttribute("currentUserEmail", currentUserEmail);
        return "success";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute("currentUserEmail", null);
        return "redirect:/";
    }
}
