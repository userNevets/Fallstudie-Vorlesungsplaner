package dhbw.vs.uniplaner.controller;

import dhbw.vs.uniplaner.domain.UniUser;
import dhbw.vs.uniplaner.service.UniUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @GetMapping("/login")
    public String login() {
        return "loginAndReg";
    }
    @GetMapping("/Reg")
    public String reg(WebRequest request, Model model) {
        System.out.println(model.toString());
        System.out.println(3);
        model.addAttribute("User", new UniUser());
        System.out.println(4);
        //uniUserService.Reg(null);
        System.out.println(7);
        return "Reg";
    }
    @PostMapping("/process_reg")
    @ResponseBody
    public String process_reg(HttpServletRequest request, @RequestBody(required = false) @ModelAttribute("User") @Valid UniUser user) {
        System.out.println(user.toString());
        //uniUserService.Reg(user);
        return "/loginAndReg";
    }
    
   @GetMapping("/main")
    public String main(){
        return "Haupt";
    }
}
