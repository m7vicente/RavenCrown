package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.EnderecoModel;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioBusiness userBusiness;

    private final ModelMapper mapper;

    public UsuarioController(){
        mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<UsuarioModel, UsuarioEntity>() {
            protected void configure(){
                map().setImagem(null);
                map().getImagem().setUsuario(map());
                map().setEmail_Usuario(source.getEmail());
                map().setEstado_Civil(source.getEstadoCivil());
                map().setNome_Usuario(source.getNome());
            }
        });
    }

    @GetMapping("/Usuario")
    public UsuarioModel LoginController (@RequestParam("id") int id) {
        UsuarioModel model = mapper.map(userBusiness.getUser(id),UsuarioModel.class);

        return model;
    }
    //http://localhost:8080/Usuario?id=11
}
