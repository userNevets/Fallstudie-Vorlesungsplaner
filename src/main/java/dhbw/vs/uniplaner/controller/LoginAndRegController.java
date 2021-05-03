package dhbw.vs.uniplaner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginAndRegController {

    @GetMapping("/login")
    public String login() {
        return "loginAndReg";
    }
}
