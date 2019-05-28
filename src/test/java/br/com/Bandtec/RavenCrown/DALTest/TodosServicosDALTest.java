package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
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
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosServicosDALTest {

    @Autowired
    TodosServicosDAL servicosDAL;
    ServicoEntity servico;

    @Autowired
    TodosUsuariosDAL usuariosDAL;
    UsuarioEntity usuario;

    @Test
    public void PersistirServico(){
        servico = new ServicoEntity();
        servico.setDescricao_Servico("Manutenção de Pias e Tanques de Lavanderia");
        servico.setLocalizacao_Fixa(false);
        servico.setNome_Servico("Pias e Tanques Conserto");
        servico.setPreco_Servico(33.59);
        servico.setPrestador(usuariosDAL.getOne(10));
        servico.setTempo_Execucao(new Date(Time.valueOf("00:10:00").getTime()));

        servicosDAL.save(servico);

        ServicoEntity servicoPerssitido = servicosDAL.getOne(servico.getId_Servico());

        assertEquals(servicoPerssitido,servico);
    }

    @Test
    public void ObterServicoTest(){

        List<ServicoEntity> todosServicos  = servicosDAL.findAll();

        assertFalse(todosServicos.isEmpty());



    }
}
