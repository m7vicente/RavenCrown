package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosDemandasDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosEnderecosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosServicosDAL;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosUsuariosDAL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodasDemandasDALTest {

    @Autowired
    TodosDemandasDAL demandasDAL;
    DemandaEntity demanda;

    @Autowired
    TodosUsuariosDAL usuariosDAL;

    @Autowired
    TodosEnderecosDAL enderecosDAL;

    @Test
    public void PersistirDemandaTest() {

        demanda = new DemandaEntity();

        demanda.setDescricao_Demanda("Dar um jeito na pia quebrada");
        demanda.setNome_Demanda("Pia Quebrada");
        demanda.setValor_Previsto(100.00);
        demanda.setEndereco(enderecosDAL.getOne(1));
        demanda.setContratante(usuariosDAL.getOne(10));

        demandasDAL.save(demanda);

        DemandaEntity demandaPerssitido = demandasDAL.getOne(demanda.getId_Demanda());

        assertEquals(demandaPerssitido, demanda);
    }

    @Test
    public void ObterDemandaTest() {
        List<DemandaEntity> todasDamandas = demandasDAL.findAll();

        assertFalse(todasDamandas.isEmpty());
    }
}
