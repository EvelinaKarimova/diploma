package ru.itis.diplom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addRedirectViewController("/","/main-page");
        registry.addViewController("/login").setViewName("sign-in-page");
        /*
        registry.addViewController("/signup").setViewName("sign-up-page");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/tasks").setViewName("tasks");
         */

    }
}
