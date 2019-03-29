package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.UserEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.SecurityApplication;
import br.com.Bandtec.RavenCrown.Web.Model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Security;

@Controller
public class LoginController {

    public final static String LOGIN_URL = "login.html";

    public final static String INDEX_URL = "index.html";

    @GetMapping("/login")
    public String LoginController (Model model) {
       model.addAttribute(new UserModel());
        return LOGIN_URL;
    }

    @PostMapping("/login")
    public String DoLogin (@ModelAttribute UserModel userModel){

        SecurityApplication Security = new SecurityApplication();

        UserEntity logingUser = new UserEntity();

        logingUser.setEmail_Usuario(userModel.userEmail);
        logingUser.setNome_Usuario(userModel.getUserName());
        logingUser.setSenha(userModel.getUserPass());

        if(Security.doLogin(logingUser)){
            return INDEX_URL;
        }else{
            return  LOGIN_URL;
        }


    }

}
