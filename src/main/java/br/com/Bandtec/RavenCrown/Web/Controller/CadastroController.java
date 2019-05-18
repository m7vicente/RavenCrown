package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CadastroController {

    @Autowired
    private UsuarioBusiness userBusiness;

//    @CrossOrigin
//    @PostMapping("/cadastro")
//    public UsuarioModel Cadastro (@RequestBody CadastroModel user){
//        UsuarioEntity usr = userBusiness.Cadastro(user);
//
//        if(usr == null){
//            return null;
//        }else{
//            return new UsuarioModel(usr);
//        }
//    }
}
