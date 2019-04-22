package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.DataServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosDatasServicoDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosServicosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@Transactional
@SpringBootTest
@Commit
@RunWith(SpringRunner.class)
public class TodosDatasServicoDALTest {

    @Autowired
    TodosDatasServicoDAL datasServicoDAL;
    DataServicoEntity dataServico;

    @Autowired
    TodosServicosDAL servicosDAL;
    ServicoEntity servico;

    @Autowired
    TodosUsuariosDAL usuariosDAL;
    UsuarioEntity usuario;

    @Before
    public void definirTest(){
        this.servico = this.servicosDAL.getOne(1);
        this.usuario = this.usuariosDAL.getOne(11);
    }

    @Test
    public void persistirData(){
        dataServico = new DataServicoEntity();

        java.util.Date DATA = new java.util.Date();
        Date data = new Date(DATA.getTime());

        dataServico.setDt_Agendamento(data);
        dataServico.setPrestador(usuario);
        dataServico.setTipo_Reserva('T');

        datasServicoDAL.save(dataServico);

        DataServicoEntity dataPersistida = datasServicoDAL.getOne(dataServico.getId_data_agendado());

        assertEquals(dataPersistida,dataServico);
    }

    @Test
    public void verirficarDatasEmServico(){
        assertFalse((servicosDAL.getOne(1).getDatas().isEmpty()));
    }
}
