package br.com.Bandtec.RavenCrown.EntityTest;

import br.com.Bandtec.RavenCrown.Entity.UserEntity;
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

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDALTest {

    @Autowired
    private UsuarioDAL userDAL;

    @Test
    public void GetUsersTest(){
        List<UserEntity> list = userDAL.findAll();

        assertTrue(list != null);
    }

    @Test
    public void InsertUser(){
        UserEntity user = new UserEntity();

        user.setSenha("54321");
        user.setNome_Usuario("Ronaldo da Silva");
        user.setEmail_Usuario("Ronaldo@silva.com.br");
        user.setCPF_CNPJ("12345678909");
        user.setEstado_Civil("Solteiro");
        user.setPrestador(false);
        user.setRG("34-333-222-X");
        user.setSexo('M');
        user.setTelefone_usuario("(11)92132-4599");

        userDAL.save(user);

        UserEntity usuarioFromDB = userDAL.getOne(user.Id_Usuario);

        assertEquals(user, usuarioFromDB);


    }

}
