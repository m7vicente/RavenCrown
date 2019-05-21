package br.com.Bandtec.RavenCrown.BusinessTest;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussiness;
import br.com.Bandtec.RavenCrown.Web.Model.ImagemServicoModel;
import br.com.Bandtec.RavenCrown.Web.Model.ServicoModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

//@Commit
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServicoBussinesTest {

    @Autowired
    ServicoBussiness serviceBusiness;

    ServicoModel model;

    ModelMapper mapper = new ModelMapper();

    @Test
    public void persistirServicoSEMImagem(){
        model = new ServicoModel();

        model.setDescricao_Servico("Alteração de pisos e azuleijos da sua cozinha, montamos pias de arrumamos calhas");
        model.setId_Usuario(11);
        model.setNome_Servico("O Famoso Pedreiro");
        model.setLocalizacao_Fixa(false);
        model.setPreco_Servico(33.33);
        model.setImagem(null);
        model.setId_Categoria(1);
        model.setTempo_Execucao(Time.valueOf("00:10:00"));

        ServicoEntity servicoSalvo = serviceBusiness.insertService(mapper.map(model,ServicoEntity.class));

        assertTrue(servicoSalvo != null);
    }

    @Test
    public void persistirServicoCOMImagem(){
        model = new ServicoModel();

        model.setDescricao_Servico("Alteração de pisos e azuleijos da sua cozinha, montamos pias de arrumamos calhas");
        model.setId_Usuario(11);
        model.setNome_Servico("O Famoso Pedreiro");
        model.setLocalizacao_Fixa(false);
        model.setPreco_Servico(33.33);
        model.setId_Categoria(1);
        model.setTempo_Execucao(Time.valueOf("00:10:00"));

        List<ImagemServicoModel> imagens = new ArrayList<>();

        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(new File("C:/Projetos/Test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, "png", bos );
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImagemServicoModel imagem = new ImagemServicoModel();
        imagem.setImage(bos.toByteArray());
        imagem.setId_Usuario(11);
        imagens.add(imagem);

        model.setImagem(imagens);

        ServicoEntity servicoSalvo = serviceBusiness.insertService((mapper.map(model,ServicoEntity.class)));

        assertTrue(servicoSalvo != null);
    }



}
