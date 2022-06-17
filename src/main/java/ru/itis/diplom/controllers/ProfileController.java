package ru.itis.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.diplom.dto.ResponseDto;
import ru.itis.diplom.dto.UserDto;
import ru.itis.diplom.models.User;
import ru.itis.diplom.security.details.UserDetailsImpl;
import ru.itis.diplom.services.ProfileService;

import java.util.Map;
import java.util.Optional;

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


/*
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String //ResponseEntity<?>
    getUserProfile(Authentication authentication, Model model) {
        Optional<User> userOptional = profileService.getCurrentUser(authentication);
        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "profile";
                    //ResponseEntity.ok(UserDto.from(userOptional.get()));
        } else {
            throw  new IllegalArgumentException("User not found");
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("User is not found"));
        }
    }

 */

    /*
    @RequestMapping(value =  "/profile", method = RequestMethod.GET)
    //@ModelAttribute("user")
    public String getUserProfile(Model model) {

        if (userCandidate.isPresent()) {
            model.addAttribute("user", userCandidate.get());
            return "profile";
        } else {
            throw new IllegalArgumentException("User is not found");
        }
    }

     */

    /*
    @GetMapping("/user")
    public String user() {
        return "<h2>Hello user!</h2>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h2>Hello admin!</h2>";
    }
     */
}
