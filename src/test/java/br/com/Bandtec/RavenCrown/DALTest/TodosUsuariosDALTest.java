package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosEnderecosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import br.com.Bandtec.RavenCrown.Web.Model.CadastroModel;
import br.com.Bandtec.RavenCrown.Web.Model.LoginModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
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
    CadastroModel userEntity_2;

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

    @Test
    public void cadastrTest(){
        userEntity_2 = new CadastroModel();

        userEntity_2.setNome_Usuario("João");
        userEntity_2.setEmail_Usuario("joaozinho@gmail.com");
        userEntity_2.setSenha("12345");

        EnderecoEntity endereco = new EnderecoEntity();
        endereco.setRua("aaaaaaaaa");
        endereco.setReferencia("aaaaaaaaaa");
        endereco.setPais("aaaaaaaa");
        endereco.setNumero("aaaaaaaaa");
        endereco.setEstado("aaaaaaaaa");
        endereco.setComplemento("aaaaaaaaa");
        endereco.setCidade("aaaaaaaa");
        endereco.setCep("aaaaaaaaaa");
        endereco.setBairro("aaaaaaaaaa");
        userEntity_2.setEndereco(endereco);
        userEntity_2.setCPF_CNPJ("111111111");
        userEntity_2.setRG("aaaaaaaaaa");
        userEntity_2.setTelefone_usuario("aaaaaaaaa");
        userEntity_2.setPrestador(true);
        userEntity_2.setSexo('M');
        userEntity_2.setEstado_Civil("Solteiro");
        Date data = new Date(1111111);
        userEntity_2.setData_Nascimento(data);
        userEntity_2.setDatasPrestar(null);
        userEntity_2.setDatasConsumir(null);
        userEntity_2.setServicosPrestar(null);
        userEntity_2.setServicosConsumir(null);
        userEntity_2.setImagem(null);

        UsuarioEntity user = business.Cadastro(userEntity_2);



        assertEquals(user, userEntity_2);
    }

}
