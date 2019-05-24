package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.ImagemUsuarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosImagemUsuairoDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Commit
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TodasImagensUsuarioDALTest {

    @Autowired
    TodosImagemUsuairoDAL imagemUsuarioDAL;
    ImagemUsuarioEntity imagem;

    @Autowired
    TodosUsuariosDAL usuariosDAL;
    UsuarioEntity usuario;

    @Test
    public void A_PersistirImagemUsuario(){

        ImagemUsuarioEntity oldImage = imagemUsuarioDAL.GetImagemByUser(10);
        if(oldImage != null)
            imagemUsuarioDAL.deleteById(oldImage.getImagem_Id());

        imagem = new ImagemUsuarioEntity();

        imagem.setImagem_Url("https://i.pinimg.com/originals/8a/3d/a2/8a3da20e55bd36a2f29f8f3ab4d0c5b5.jpg");
        imagem.setUsuario(usuariosDAL.getOne(10));

        imagemUsuarioDAL.save(imagem);

        ImagemUsuarioEntity imagemPerssitido = imagemUsuarioDAL.getOne(imagem.getImagem_Id());

        assertEquals(imagemPerssitido,imagem);
    }

    @Test
    public void B_ObterImagemUsuarioTest(){

        ImagemUsuarioEntity ImagemDoUsuario  = imagemUsuarioDAL.GetImagemByUser(10);

        assertEquals(ImagemDoUsuario.getUsuario().getId_Usuario() ,10);
    }

}
