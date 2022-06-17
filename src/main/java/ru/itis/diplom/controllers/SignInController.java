package ru.itis.diplom.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.diplom.dto.SignInDto;
import ru.itis.diplom.services.SignInService;

import java.util.Map;


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

    /*
    @GetMapping("/login")
    public String getLoginPage() {
        return "sign-in-page";
    }

     */



    @GetMapping("/sign_in&error")
    public String getErrorPage(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("active_menu_attr", "login");
        return "error_page";
    }


    /*
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String singIn(
            //SignInDto dto, Map<String, Object> model
            ) {
        //try {
        //SignInDto dto = new SignInDto((String) model.getAttribute("username"), (String) model.getAttribute("password"));
        //signInService.signIn(dto);
        //model.put("message", "wtf");
        return "/profile";
        //} catch (Exception e) {
        //    model.addAttribute("message", e.getMessage());
        //    return "redirect:/login";
        //}
    }
     */


    /*
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost (@RequestBody SignInDto dto) {
        signInService.signIn(dto);
        return "redirect:/profile";
    }
     */


}