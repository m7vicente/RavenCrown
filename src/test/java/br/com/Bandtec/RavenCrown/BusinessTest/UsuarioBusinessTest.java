package br.com.Bandtec.RavenCrown.BusinessTest;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Entity.ImagemUsuarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.LoginModel;
import br.com.Bandtec.RavenCrown.Web.Model.UsuarioModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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
    @Autowired
    private UsuarioBusiness userBusiness;

    LoginModel userEntity;

    @Before
    public void UsuarioBusinessTest(){
        UsuarioEntity userModel = new UsuarioEntity();

        userModel.setEmail_Usuario("teste@revencrown");
        userModel.setNome_Usuario("Usuario de teste");
        userModel.setTelefone_usuario("4002-8922");
        userModel.setEstado_Civil("Solteiro");
        userModel.setSexo('I');
        userModel.setPrestador(false);
        userModel.setRG("XX.XXX.XX-X");
        userModel.setCPF_CNPJ("123.456.789-09");
        userModel.setSenha("string");
        userBusiness.Cadastro(userModel);

    }

    @Test
    public void LoginTest(){
        userEntity = new LoginModel();

        userEntity.setEmail("teste@revencrown");
        userEntity.setSenha("string");

        UsuarioEntity userFromDB =  business.Login(userEntity.getEmail(),userEntity.getSenha());

        assertTrue(userFromDB != null);
    }
}
