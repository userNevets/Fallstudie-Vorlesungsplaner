package dhbw.vs.uniplaner.controller;

import dhbw.vs.uniplaner.domain.UniUser;
import dhbw.vs.uniplaner.service.UniUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
public class LoginAndRegController {
    
    @Autowired
    private UniUserService uniUserService;

    @Autowired
    private PasswordEncoder pwEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/Reg")
    public String reg(WebRequest request, Model model) {
        model.addAttribute("User", new UniUser());
        //uniUserService.Reg(null);
        return "Reg";
    }
    @PostMapping("/process_reg")
    @ResponseBody
    public String process_reg(HttpServletRequest request, @RequestBody(required = false) @ModelAttribute("User") @Valid UniUser user) {
        System.out.println(user.toString());
        user.setPassword(pwEncoder.encode(user.getPassword()));
        uniUserService.Reg(user);
        return "login";
    }
    
   @GetMapping("/main")
    public String main(){
        return "Haupt";
    }
}
