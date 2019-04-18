package br.com.Bandtec.RavenCrown.EntityTest;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.EnderecoDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.UsuarioDAL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDALTest {

    @Autowired
    private UsuarioDAL userDAL;

    @Autowired
    private EnderecoDAL enderecoDAL;

    @Test
    public void GetUsersTest(){
        List<UsuarioEntity> list = userDAL.findAll();

        assertFalse(list.isEmpty());
    }

    @Test
    public void InsertUser(){
        EnderecoEntity endereco = enderecoDAL.getOne(11);

        UsuarioEntity user = new UsuarioEntity();

        user.setSenha("54321");
        user.setNome_Usuario("Ronaldo da Silva");
        user.setEmail_Usuario("Ronaldo@silva.com.br");
        user.setCPF_CNPJ("12345678909");
        user.setEstado_Civil("Solteiro");
        user.setPrestador(false);
        user.setRG("34-333-222-X");
        user.setSexo('M');
        user.setTelefone_usuario("(11)92132-4599");
        user.setId_Endereco(endereco);

        userDAL.save(user);

        UsuarioEntity usuarioFromDB = userDAL.getOne(user.Id_Usuario);

        assertEquals(user, usuarioFromDB);
    }

}
