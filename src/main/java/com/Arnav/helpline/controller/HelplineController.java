package com.Arnav.helpline.controller;

import com.Arnav.helpline.model.Helpline;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelplineController {

    @PostMapping("/user")
    public String submitConcern(Helpline helpline) {
        return "submitted";
    }
}
