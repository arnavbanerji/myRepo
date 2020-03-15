package com.Arnav.helpline.controller;

import com.Arnav.helpline.model.Helpline;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HelplineController {

    @GetMapping(value = "/user")
    public String user(Principal principal, HttpSession session) {
        session.setAttribute("userDetails",((OAuth2Authentication) principal).getUserAuthentication().getDetails());
        return "home";
    }

    @PostMapping("/user")
    public String submitConcern(@RequestParam String textForm, Model model) {
        return "submitted";
    }
}
