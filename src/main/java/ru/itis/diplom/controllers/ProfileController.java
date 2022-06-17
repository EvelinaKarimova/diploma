package ru.itis.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.diplom.services.ProfileService;

@Controller
public class ProfileController {
    @Autowired
    ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profile")
    public String getProfile(Model model, Authentication authentication) {
        model.addAttribute("active_menu_attr", "profile");
        model.addAttribute("current_user", profileService.getCurrentUser(authentication).get());
        model.addAttribute("authentication", authentication);
        return "profile";
    }

    @GetMapping("/profile-settings")
    public String getSettingsPage(Model model, Authentication authentication) {
        model.addAttribute("active_menu_attr", "profile");
        model.addAttribute("current_user", profileService.getCurrentUser(authentication).get());
        model.addAttribute("authentication", authentication);
        return "profile-settings";
    }
}
