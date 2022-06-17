package ru.itis.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.diplom.dto.SignUpDto;
import ru.itis.diplom.services.SignUpService;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class SignUpController {
    @Autowired
    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpPage(Model model) {
        model.addAttribute("active_menu_attr", "signup");
        return "sign-up-page";
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doPost(@Valid SignUpDto dto
            ) {
        //SignUpDto dto = new SignUpDto((String) model.getAttribute("username"), (String) model.getAttribute("firstName"),"e","e","e@e.e", "e", "e");
        signUpService.signUp(dto);
        return "redirect:/login";
    }
}
