package com.dario.ift.api.v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class BaseController {

    @GetMapping("/")
    public ResponseEntity<?> getApplicationHealth() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
