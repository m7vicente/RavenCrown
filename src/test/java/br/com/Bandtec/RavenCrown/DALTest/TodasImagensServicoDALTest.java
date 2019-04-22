package br.com.Bandtec.RavenCrown.DALTest;


import br.com.Bandtec.RavenCrown.Entity.ImagemServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosImagemServicoDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosServicosDAL;
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
public class TodasImagensServicoDALTest {
    @Autowired
    TodosImagemServicoDAL imagemServicoDAL;
    ImagemServicoEntity imagem;

    @Autowired
    TodosUsuariosDAL usuariosDAL;
    UsuarioEntity usuario;

    @Autowired
    TodosServicosDAL servicosDAL;
    UsuarioEntity servico;

    @Test
    public void PersistirImagemServicoTest(){
        imagem = new ImagemServicoEntity();

        imagem.setImagem_URL("https://i.pinimg.com/originals/8a/3d/a2/8a3da20e55bd36a2f29f8f3ab4d0c5b5.jpg");
        imagem.setUsuario(usuariosDAL.getOne(10));
        imagem.setServico(servicosDAL.getOne(1));

        imagemServicoDAL.save(imagem);

        ImagemServicoEntity imagemPerssitido = imagemServicoDAL.getOne(imagem.getId_Imagem_Servico());

        assertEquals(imagemPerssitido,imagem);
    }

    @Test
    public void ObterImagemServicoTest(){

        List<ImagemServicoEntity> todasImagemDoServico  = imagemServicoDAL.findAll();

        assertFalse(todasImagemDoServico.isEmpty());
    }
}
