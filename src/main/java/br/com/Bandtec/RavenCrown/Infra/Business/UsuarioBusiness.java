package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

public class UsuarioBusiness {

    @Autowired
    TodosUsuariosDAL userdal;

    public UsuarioEntity Login(String email, String senha){

        UsuarioEntity entity = new UsuarioEntity();
        entity.setEmail_Usuario(email);
        entity.setSenha(senha);

        if(new SecurityApplication(userdal.findAll()).doLogin(entity)) {
            entity = userdal.getByUserAndPass(entity.getEmail_Usuario(), entity.getSenha());
            return entity;
        }
        return null;
    }

}
