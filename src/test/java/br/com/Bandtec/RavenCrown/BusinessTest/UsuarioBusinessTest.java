package br.com.Bandtec.RavenCrown.BusinessTest;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.LoginModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioBusinessTest {

    @Autowired
    private UsuarioBusiness business;

    LoginModel userEntity;

    @Test
    public void LoginTest(){
        userEntity = new LoginModel();

        userEntity.setEmail("SISTEMA@RAVENCHROWN");
        userEntity.setSenha("");

        UsuarioEntity userFromDB =  business.Login(userEntity.getEmail(),userEntity.getSenha());

        assertTrue(userFromDB != null);
    }
}
