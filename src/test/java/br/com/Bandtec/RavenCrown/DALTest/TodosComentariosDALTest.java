package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.ComentarioEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosComentariosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosServicosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosComentariosDALTest {

    @Autowired
    private TodosComentariosDAL todosComentariosDAL;

    @Autowired
    TodosUsuariosDAL usuariosDAL;
    UsuarioEntity usuario;

    @Autowired
    TodosServicosDAL servicosDAL;
    UsuarioEntity servico;


    @Test
    public void ComentarioGetTest(){

        List<ComentarioEntity> comentario = todosComentariosDAL.findAll();
        assertTrue(comentario.size() > 0);
    }

    @Test
    public void PersistirComentario(){
        ComentarioEntity comentario = new ComentarioEntity();

        java.util.Date DATA = new java.util.Date();
        Date data = new Date(DATA.getTime());

        comentario.setData_Comentario(data);
        comentario.setDe_Comentario("Testes do Spring Boot");
        comentario.setServico(servicosDAL.getOne(1));
        comentario.setUsuario(usuariosDAL.getOne(10));

        todosComentariosDAL.save(comentario);

        ComentarioEntity comentarioEntitySalvo = todosComentariosDAL.getOne(comentario.getId_Comentario());

        assertEquals(comentario,comentarioEntitySalvo);
    }

}
