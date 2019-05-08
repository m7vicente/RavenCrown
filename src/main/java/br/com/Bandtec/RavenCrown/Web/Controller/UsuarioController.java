package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioBusiness userBusiness;

    @GetMapping("/Usuario")
    public UsuarioModel LoginController (@RequestParam("id") int id) {
        return new UsuarioModel(userBusiness.getUser(id));
    }
    //http://localhost:8080/Usuario?id=11
}
