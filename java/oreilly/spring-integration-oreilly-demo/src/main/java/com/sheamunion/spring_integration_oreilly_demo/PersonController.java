package com.sheamunion.spring_integration_oreilly_demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/ping")
    public ResponseEntity ping() { return ResponseEntity.ok("pong"); }
}
