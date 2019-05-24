package br.com.Bandtec.RavenCrown.BusinessTest;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.ImagemUsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemUsuarioModel;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

@Commit
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImagemUsuarioBusinessTest {

    @Autowired
    private UsuarioBusiness business;

    @Autowired
    private ImagemUsuarioBusiness ImageBusiness;

    int Id_Usuario = 10;


    @Test
    public void A_PersistImage(){

        ImagemUsuarioModel imagemUsuarioModel = new ImagemUsuarioModel();
        imagemUsuarioModel.setId_Usuario(Id_Usuario);

        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(new File("C:/Projetos/UserTest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, "png", bos );
        } catch (IOException e) {
            e.printStackTrace();
        }
        imagemUsuarioModel.setImage(bos.toByteArray());

        imagemUsuarioModel = ImageBusiness.InsertUserImage(imagemUsuarioModel);

        assertTrue(imagemUsuarioModel.getImage() != null);
    }

    @Test
    public void B_GetUserImage(){
        ImagemUsuarioModel image = ImageBusiness.GetUserImage(Id_Usuario);

        assertTrue(image.getImage() != null);
    }

}
