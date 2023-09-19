package com.example.devmodule15.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping
    public ModelAndView mainPage(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String name = authentication.getName();
        ModelAndView modelAndView = new ModelAndView("home_page");
        modelAndView.addObject("username", name);
        return modelAndView;
    }

    @GetMapping("/userInfo")
    public @ResponseBody Map<String, String> getUserInfo(@AuthenticationPrincipal UserDetails userDetails){
        Map<String, String> info = new HashMap<>();
        info.put("Name", userDetails.getUsername());
        info.put("Authorities", userDetails.getAuthorities().toString());
        info.put("isEnabled", String.valueOf(userDetails.isEnabled()));
        return info;
    }
}
