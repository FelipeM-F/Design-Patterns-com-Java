package controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return "welcome to my spring boot  web application";
    }
}
