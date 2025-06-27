package clcd.practice.jenkins.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

    private final String secretValue1;
    private final String secretValue2;

    public CheckController(
            @Value("${custom.secret_value1}") String secretValue1,
            @Value("${custom.secret_value1}") String secretValue2
    ) {
        this.secretValue1 = secretValue1;
        this.secretValue2 = secretValue2;
    }

    @GetMapping("/health-check")
    public String checkHealth() {
        return "Connection OK!";
    }

    @GetMapping("/version-check")
    public String checkVersion() {
        return "version 3";
    }

    @GetMapping("/credential-check")
    public String checkCredential() {
        return String.format("secretValue1 : %s, secretValue2 : %s", secretValue1, secretValue2);
    }
}
