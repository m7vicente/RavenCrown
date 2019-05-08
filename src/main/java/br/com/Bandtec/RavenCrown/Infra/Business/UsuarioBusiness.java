package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import br.com.Bandtec.RavenCrown.Web.Model.CadastroModel;
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

    public UsuarioEntity Cadastro(CadastroModel user){

        UsuarioEntity entity = new UsuarioEntity();
        entity.setEmail_Usuario(user.getEmail_Usuario());
        entity.setSenha(user.getSenha());
        entity.setEndereco(user.getEndereco());
        entity.setNome_Usuario(user.getNome_Usuario());
        entity.setCPF_CNPJ(user.getCPF_CNPJ());
        entity.setRG(user.getRG());
        entity.setTelefone_usuario(user.getTelefone_usuario());
        entity.setPrestador(user.isPrestador());
        entity.setSexo(user.getSexo());
        entity.setEstado_Civil(user.getEstado_Civil());
        entity.setData_Nascimento(user.getData_Nascimento());
        entity.setDatasPrestar(user.getDatasPrestar());
        entity.setDatasConsumir(user.getDatasConsumir());
        entity.setServicosPrestar(user.getServicosPrestar());
        entity.setServicosConsumir(user.getServicosConsumir());
        entity.setImagem(user.getImagem());

        UsuarioEntity usuarioEncontrado = userdal.getByEmail(entity.getEmail_Usuario());

        if(usuarioEncontrado == null){
            userdal.save(entity);
            System.out.println("Usuário cadastrado com sucesso!");
            return entity;
        } else {
            return null;
        }
    }

}
