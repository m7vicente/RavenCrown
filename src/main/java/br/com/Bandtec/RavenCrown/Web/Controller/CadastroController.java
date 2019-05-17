package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.CadastroModel;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CadastroController {

    @Autowired
    private UsuarioBusiness userBusiness;

    @CrossOrigin
    @PostMapping("/cadastro")
    public UsuarioModel Cadastro (@RequestBody UsuarioModel user){
        ModelMapper mapper = new ModelMapper();
        UsuarioModel usr =
                mapper.map(userBusiness.Cadastro(
                        mapper.map(user,UsuarioEntity.class)),UsuarioModel.class);

        if(usr == null){
            return null;
        }else{
            return usr;
        }
    }
}
