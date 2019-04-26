package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.SecurityApplication;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private final UsuarioBusiness userBusiness = new UsuarioBusiness();

    @GetMapping("/login")
    public String LoginController (Model model) {
       model.addAttribute(new UserModel());
        return "";
    }

    @CrossOrigin
    @PostMapping("/login")
    public UsuarioEntity DoLogin (@RequestBody String email,@RequestBody String senha){
        return userBusiness.Login(email,senha);
    }

}
