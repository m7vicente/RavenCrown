package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
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
        entity.setSenha(new Encryption().Encript(senha));

        List<UsuarioEntity> users = userdal.findAll();

        int userExist = new SecurityApplication(users).doLogin(entity);

        if(userExist > -1) {
            entity = users.get(userExist);
            return entity;
        }
        return null;
    }
    public UsuarioEntity getUser(int Id){
        return userdal.getOne(Id);
    }

    public UsuarioEntity Cadastro(String nome, String email, EnderecoEntity endereco, String senha){

        UsuarioEntity entity = new UsuarioEntity();
        entity.setNome_Usuario(nome);
        entity.setEmail_Usuario(email);
        entity.setEndereco(endereco);
        entity.setSenha(senha);

        UsuarioEntity usuarioEncontrado = userdal.getByEmail(entity.getEmail_Usuario());

        if(usuarioEncontrado == null){
            return null;
        } else {
            userdal.save(entity);
            return entity;
        }
    }

    public UsuarioEntity Cadastro(UsuarioEntity user){

        UsuarioEntity usuarioEncontrado = userdal.getByEmail(user.getEmail_Usuario());

        if(usuarioEncontrado == null){
            user.setSenha(new Encryption().Encript(user.getSenha()));
            userdal.save(user);
            System.out.println("Usuário cadastrado com sucesso!");
            return user;
        } else {
            return null;
        }
    }

    public boolean Update(UsuarioEntity entity) {

        UsuarioEntity usuarioEncontrado = userdal.getByEmail(entity.getEmail_Usuario());
        if(usuarioEncontrado != null){
            entity.setSenha(new Encryption().Encript(entity.getSenha()));
            userdal.save(entity);
            System.out.println("Usuário cadastrado com sucesso!");
            return true;
        } else {
            return false;
        }

    }
}