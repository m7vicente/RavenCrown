package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CadastroController {

    @Autowired
    private UsuarioBusiness userBusiness;

    private final ModelMapper mapper;

    public CadastroController(){
        mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<UsuarioModel, UsuarioEntity>() {
            protected void configure(){
                map().setImagem(null);
                map().getImagem().setUsuario(map());
                map().setEmail_Usuario(source.getEmail());
                map().setEstado_Civil(source.getEstadoCivil());
                map().setNome_Usuario(source.getNome());
                map().setCPF_CNPJ(source.getCpfCnpj());
            }
        });
    }

    @CrossOrigin
    @PostMapping("/cadastro")
    public UsuarioModel Cadastro (@RequestBody UsuarioModel user){


        UsuarioModel usr = mapper.map(userBusiness.Cadastro(mapper.map(user,UsuarioEntity.class)),UsuarioModel.class);

        if(usr == null){
            return null;
        }else{
            return usr;
        }
    }
}
