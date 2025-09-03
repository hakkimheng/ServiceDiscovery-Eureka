package com.openfeign.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
class MessageController {

    @Value("${app.message}")
    private String message;

    @GetMapping
    public String getTest(){
        return message;
    }
}


