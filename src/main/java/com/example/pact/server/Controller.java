package com.example.pact.server;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pact")
public class Controller {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsers() {
        return "{\"condition\": true,\"name\": \"tom\", \"surname\": \"doe\"}";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String postUsers() {
        return "{\"condition\": true, \"surname\": \"Doe\"}";
    }

}
