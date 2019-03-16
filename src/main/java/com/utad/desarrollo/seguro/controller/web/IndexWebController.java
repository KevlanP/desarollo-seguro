package com.utad.desarrollo.seguro.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

@Controller
public class IndexWebController {

    @GetMapping("/")
    public String index(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {

        model.addAttribute("name", HtmlUtils.htmlEscape(name));
        return "index.jsp";

    }

}