package br.com.Bandtec.RavenCrown.Web.Controller;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.ImagemUsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.LoginModel;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private UsuarioBusiness userBusiness;

    @Autowired
    private ImagemUsuarioBusiness userImageBusiness;
    private ModelMapper mapper;

    public LoginController(){
        this.mapper = new ModelMapper();
        this.mapper.addMappings(new PropertyMap<UsuarioEntity, UsuarioModel>() {
            protected void configure(){
                map().setImagem(null);
                map().setEmail(source.getEmail_Usuario());
                map().setEstadoCivil(source.getEstado_Civil());
                map().setNome(source.getNome_Usuario());
                map().setCpfCnpj(source.getCPF_CNPJ());
                map().setTelefone(source.getTelefone_usuario());
            }
        });
    }

    @GetMapping("/login")
    public ResponseEntity<UsuarioModel> LoginController (@RequestParam("Id") int id) {
        ModelMapper mapper = new ModelMapper();
        return new ResponseEntity<>(mapper.map(userBusiness.getUser(id),UsuarioModel.class),HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<UsuarioModel> Login (@RequestBody LoginModel user){

        ModelMapper mapper = new ModelMapper();
        UsuarioModel usr = mapper.map(userBusiness.Login(user.getEmail(),user.getSenha()),UsuarioModel.class);

        if(usr == null){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else{
            usr.setImagem(userImageBusiness.GetUserImage(usr.getId_Usuario()));
            return new ResponseEntity<>(usr, HttpStatus.OK);
        }
    }
//    http://localhost:8080/login
    //    {"email" : "email@email.com","senha" : "))@@@@$$$"}

}
