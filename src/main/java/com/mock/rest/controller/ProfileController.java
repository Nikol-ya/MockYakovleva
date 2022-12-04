package com.mock.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mock.rest.model.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController

public class ProfileController {

    @GetMapping("/")
    public Profile getProfile() {
            return new Profile (
                    "Login",
                    123
            );
    }

    @PostMapping("/")
    public String passAuthorization (@RequestBody Profile profile) throws JsonProcessingException, InterruptedException {
        String login = profile.getLogin();
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Map<String, String> response = new HashMap<>();
        response.put("login", login);
        response.put("date", dateFormat.format(dateNow));
        ObjectMapper objectMapper = new ObjectMapper();
        String responseJson = objectMapper.writeValueAsString(response);
        TimeUnit.SECONDS.sleep(3);
        return responseJson;
    }
}
