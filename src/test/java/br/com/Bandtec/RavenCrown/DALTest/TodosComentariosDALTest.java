package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.ComentarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosComentariosDAL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertTrue;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosComentariosDALTest {

    @Autowired
    private TodosComentariosDAL todosComentariosDAL;


    @Test
    public void ComentarioGetTest(){

        List<ComentarioEntity> comentario = todosComentariosDAL.findAll();
        assertTrue(comentario.size() > 0);
    }

}
