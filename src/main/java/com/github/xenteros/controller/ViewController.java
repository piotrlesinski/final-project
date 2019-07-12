package com.github.xenteros.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
class ViewController {


    @GetMapping("/login-success")
    public String loginSuccess(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        return "login-success";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "redirect:/login-page.html";
    }
}
