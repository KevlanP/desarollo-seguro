package com.utad.desarrollo.seguro.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginWebController {

    @GetMapping("/login")
    public String login(
            @RequestParam(name = "failure", required = false, defaultValue = "false") Boolean failure,
            Model model) {

        model.addAttribute("failure", failure);
        return "login.jsp";

    }

}
