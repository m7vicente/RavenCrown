package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.LoginModel;
import br.com.Bandtec.RavenCrown.Web.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private UsuarioBusiness userBusiness;

    @GetMapping("/login")
    public String LoginController (Model model) {
       model.addAttribute(new UserModel());
        return "";
    }

    @CrossOrigin
    @PostMapping("/login")
    public LoginModel Login (@RequestBody LoginModel user){
        UsuarioEntity usr = userBusiness.Login(user.getEmail(),user.getSenha());

        LoginModel model = new LoginModel();

        model.setEmail(usr.getEmail_Usuario());
        model.setSenha(usr.getSenha());

        return model;
    }

}
