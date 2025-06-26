package clcd.practice.jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/health-check")
    public String checkHealth() {
        return "Connection OK!";
    }

    @GetMapping("/version-check")
    public String checkVersion() {
        return "version 2";
    }
}
