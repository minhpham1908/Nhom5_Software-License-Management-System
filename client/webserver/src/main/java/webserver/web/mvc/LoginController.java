package webserver.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage(Model model){
        return "login";
    }

    @GetMapping("/perform_login")
    public String processLogin(Model model, String username, String password){
        System.out.println(username);
        System.out.println(password);
        return "index";
    }

}
