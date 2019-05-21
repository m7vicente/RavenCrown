package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosEnderecosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import br.com.Bandtec.RavenCrown.Web.Model.LoginModel;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosUsuariosDALTest {

    @Autowired
    private TodosUsuariosDAL userDAL;

    @Autowired
    private TodosEnderecosDAL todosEnderecosDAL;

    @Autowired
    private UsuarioBusiness business;

    LoginModel userEntity;

    UsuarioModel UserModel;

    @Test
    public void GetUsersTest(){
        List<UsuarioEntity> list = userDAL.findAll();

        assertFalse(list.isEmpty());
    }

    @Test
    public void InsertUser(){
        EnderecoEntity endereco = todosEnderecosDAL.getOne(11);

        UsuarioEntity user = new UsuarioEntity();

        user.setSenha("rv2058");
        user.setNome_Usuario("Vitoria Regina");
        user.setEmail_Usuario("vitoria@outlook.com");
        user.setCPF_CNPJ("71294533817");
        user.setEstado_Civil("Casada");
        user.setPrestador(false);
        user.setRG("34-443-443-X");
        user.setSexo('F');
        user.setTelefone_usuario("(11) 4002-8922");
        user.setEndereco(endereco);

        userDAL.save(user);

        UsuarioEntity usuarioFromDB = userDAL.getOne(user.getId_Usuario());

        assertEquals(user, usuarioFromDB);
    }

    @Test
    public void testLogin(){

        EnderecoEntity endereco = todosEnderecosDAL.getOne(11);

        UsuarioEntity user = new UsuarioEntity();
        user.setSenha("rv2058");
        user.setNome_Usuario("Vitoria Regina");
        user.setEmail_Usuario("vitoria@outlook.com");
        user.setCPF_CNPJ("71294533817");
        user.setEstado_Civil("Casada");
        user.setPrestador(false);
        user.setRG("34-443-443-X");
        user.setSexo('F');
        user.setTelefone_usuario("(11) 4002-8922");
        user.setEndereco(endereco);

        userDAL.save(user);

        UsuarioEntity login = userDAL.getByUserAndPass(user.getEmail_Usuario(),user.getSenha());

        assertEquals(login,user);
    }
}
