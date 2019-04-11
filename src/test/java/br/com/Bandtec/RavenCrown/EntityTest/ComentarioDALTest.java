package br.com.Bandtec.RavenCrown.EntityTest;

import br.com.Bandtec.RavenCrown.Entity.ComentarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.ComentarioDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.UsuarioDAL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class ComentarioDALTest {

    @Autowired
    private ComentarioDAL comentarioDAL;


    @Test
    public void ComentarioGetTest(){

        ComentarioEntity comentario = comentarioDAL.getOne(1);
        assertTrue(comentario != null);
    }

}
