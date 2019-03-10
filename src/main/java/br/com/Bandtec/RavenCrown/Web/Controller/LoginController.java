package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Web.Model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    public final static String LOGIN_URL = "login.html";

    public final static String INDEX_URL = "index.html";

    @GetMapping("/login")
    public String LoginController (Model model){
       return LOGIN_URL;
    }

    @PostMapping("/login")
    public String DoLogin (@ModelAttribute UserModel userModel){
        return INDEX_URL;
    }

}
