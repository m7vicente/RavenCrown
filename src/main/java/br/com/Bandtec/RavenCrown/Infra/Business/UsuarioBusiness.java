package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioBusiness {

    @Autowired
    private TodosUsuariosDAL userdal;

    public UsuarioEntity Login(String email, String senha){

        UsuarioEntity entity = new UsuarioEntity();
        entity.setEmail_Usuario(email);
        entity.setSenha(senha);

        List<UsuarioEntity> users = userdal.findAll();

        boolean userExist = new SecurityApplication(users).doLogin(entity);

        if(userExist) {
            entity = userdal.getByUserAndPass(entity.getEmail_Usuario(), entity.getSenha());
            return entity;
        }
        return null;
    }

}
