package ru.itis.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.diplom.services.SignInService;


@Controller
public class SignInController {
    @Autowired
    private final SignInService signInService;

    public SignInController(SignInService signInService) {
        this.signInService = signInService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String signin(Model model) {
        model.addAttribute("active_menu_attr", "login");
        return "sign-in-page";
    }
    @GetMapping("/sign_in&error")
    public String getErrorPage(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("active_menu_attr", "login");
        return "error_page";
    }
}