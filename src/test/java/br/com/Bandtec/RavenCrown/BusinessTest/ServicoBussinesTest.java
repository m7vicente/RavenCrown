package br.com.Bandtec.RavenCrown.BusinessTest;

import br.com.Bandtec.RavenCrown.DALTest.TodasCategoriasDALTest;
import br.com.Bandtec.RavenCrown.Entity.ImagemServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.ImagemServicoBussines;
import br.com.Bandtec.RavenCrown.Infra.Business.ServicoBussiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosCategoriasDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
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
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServicoBussinesTest {

    @Autowired
    ServicoBussiness serviceBusiness;

    @Autowired
    TodosUsuariosDAL userDAL;

    @Autowired
    TodosCategoriasDAL catDAL;

    @Autowired
    ImagemServicoBussines imagemServicoBussines;

    ServicoEntity model;

    ModelMapper mapper = new ModelMapper();

    @Test
    public void persistirServicoSEMImagem(){
        model = new ServicoEntity();

        model.setDescricao_Servico("Alteração de pisos e azuleijos da sua cozinha, montamos pias de arrumamos calhas");
        model.setPrestador(userDAL.getOne(11));
        model.setNome_Servico("O Famoso Pedreiro");
        model.setLocalizacao_Fixa(false);
        model.setPreco_Servico(33.33);
        model.setImagens(null);
        model.setCategoria(catDAL.getOne(1));

        Time timer = new Time(Time.valueOf("10:00:00").getTime());
        java.sql.Date date = new java.sql.Date(timer.getTime());

        model.setTempo_Execucao(LocalTime.now());

        ServicoEntity servicoSalvo = serviceBusiness.insertService(model);

        assertTrue(servicoSalvo != null);
    }

//    @Test
//    public void persistirServicoCOMImagem(){
//        model = new ServicoEntity();
//
//        model.setDescricao_Servico("Criação de aplicações que monitoram o sistema operacional");
//        model.setPrestador(userDAL.getOne(11));
//        model.setNome_Servico("Full bitfrosts");
//        model.setLocalizacao_Fixa(false);
//        model.setPreco_Servico(100.33);
//        model.setCategoria(catDAL.getOne(1));
//
//        Time timer = new Time(Time.valueOf("00:10:00").getTime());
//        java.sql.Date date = new java.sql.Date(timer.getTime());
//
//        model.setTempo_Execucao(date);
//
//        ServicoEntity servicoSalvo = serviceBusiness.insertService((mapper.map(model,ServicoEntity.class)));
//
//        List<ImagemServicoEntity> imagens = new ArrayList<>();
//
//        BufferedImage bImage = null;
//        try {
//            bImage = ImageIO.read(new File("C:/Projetos/Test.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        try {
//            ImageIO.write(bImage, "png", bos );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ImagemServicoModel imagem = new ImagemServicoModel();
//        imagem.setImage(bos.toByteArray());
//        imagem.setId_Usuario(servicoSalvo.getPrestador().getId_Usuario());
//        imagem.setId_Servico(servicoSalvo.getId_Servico());
//
//        imagemServicoBussines.SaveImage(imagem,servicoSalvo);
//
//        ImagemServicoEntity serviceImage = new ImagemServicoEntity();
//        serviceImage.setServico(servicoSalvo);
//        serviceImage.setUsuario(servicoSalvo.getPrestador());
//        serviceImage.setImagem_URL(imagem.getImagem_URL());
//        imagens.add(serviceImage);
//        servicoSalvo.setImagens(imagens);
//
//        assertTrue(servicoSalvo != null && !servicoSalvo.getImagens().isEmpty());
//    }



}
