package ru.netology.authorizeapp.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizeapp.authorities.Authorities;
import ru.netology.authorizeapp.service.AuthorizationService;

import java.util.List;

@AllArgsConstructor
@RestController
public class AuthorizationController {

    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAutorities(@RequestParam("user") String userName,
                                           @RequestParam("password") String password) {
        return service.getAuthorities(userName, password);
    }



}
