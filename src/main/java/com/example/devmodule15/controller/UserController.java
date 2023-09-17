package com.example.devmodule15.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/userInfo")
    public @ResponseBody Map<String, String> getUserInfo(@AuthenticationPrincipal UserDetails userDetails){
        Map<String, String> info = new HashMap<>();
        info.put("Name", userDetails.getUsername());
        info.put("Authorities", userDetails.getAuthorities().toString());
        info.put("isEnabled", String.valueOf(userDetails.isEnabled()));
        return info;
    }
}