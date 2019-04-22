package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.ImagemUsuarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosImagemUsuairoDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodasImagensUsuarioDALTest {

    @Autowired
    TodosImagemUsuairoDAL imagemUsuarioDAL;
    ImagemUsuarioEntity imagem;

    @Autowired
    TodosUsuariosDAL usuariosDAL;
    UsuarioEntity usuario;

    @Test
    public void PersistirImagemUsuario(){
        imagem = new ImagemUsuarioEntity();

        imagem.setImagem_Url("https://i.pinimg.com/originals/8a/3d/a2/8a3da20e55bd36a2f29f8f3ab4d0c5b5.jpg");
        imagem.setUsuario(usuariosDAL.getOne(10));

        imagemUsuarioDAL.save(imagem);

        ImagemUsuarioEntity imagemPerssitido = imagemUsuarioDAL.getOne(imagem.getImagem_Id());

        assertEquals(imagemPerssitido,imagem);
    }

    @Test
    public void ObterImagemUsuarioTest(){

        List<ImagemUsuarioEntity> todasImagemDoUsuario  = imagemUsuarioDAL.findAll();

        assertFalse(todasImagemDoUsuario.isEmpty());
    }

}
