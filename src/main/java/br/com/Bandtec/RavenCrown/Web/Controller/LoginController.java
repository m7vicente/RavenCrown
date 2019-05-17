package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.LoginModel;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UsuarioBusiness userBusiness;

    @GetMapping("/login")
    public UsuarioModel LoginController (@RequestParam("Id") int id) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(userBusiness.getUser(id),UsuarioModel.class);
    }

    @CrossOrigin
    @PostMapping("/login")
    public UsuarioModel Login (@RequestBody LoginModel user){
        ModelMapper mapper = new ModelMapper();
        UsuarioModel usr = mapper.map(userBusiness.Login(user.getEmail(),user.getSenha()),UsuarioModel.class);
        if(usr == null){
            return null;
        }else{
            return usr;
        }
    }
//    http://localhost:8080/login
//    {"email" : "email@email.com","senha" : "))@@@@$$$"}

}
