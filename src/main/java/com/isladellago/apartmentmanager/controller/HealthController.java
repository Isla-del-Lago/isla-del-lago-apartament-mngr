package com.isladellago.apartmentmanager.controller;

import com.isladellago.apartmentmanager.util.PathUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathUtils.BASE_PATH)
@CrossOrigin("*")
public class HealthController {

    @GetMapping("/health")
    public final ResponseEntity<String> health() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Service is healthy");
    }
}
