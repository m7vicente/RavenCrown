package br.com.Bandtec.RavenCrown.DALTest;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class TodosContratosDALTest {

    @Autowired
    TodosContratosDAL contratosDAL;
    ContratoEntity contrato;

    @Autowired
    TodosServicosDAL servicosDAL;

    @Autowired
    TodosDemandasDAL demandasDAl;

    @Autowired
    TodosUsuariosDAL usuariosDAL;

    @Autowired
    TodosEnderecosDAL enderecosDAL;

    @Test
    public void PersistirUmContratoDeServicoTest(){
        contrato = new ContratoEntity();

        contrato.setConsumidor(usuariosDAL.getOne(10));
        contrato.setPrestador(usuariosDAL.getOne(11));
        contrato.setServico(servicosDAL.getOne(1));
        contrato.setAprovado_Consumidor(false);
        contrato.setAprovado_Prestador(false);
        contrato.setEndereco(enderecosDAL.getOne(12));
        contrato.setPago(false);
        contrato.setValor_Final(200.00);

        contratosDAL.save(contrato);

        ContratoEntity contratoPersistido = contratosDAL.getOne(contrato.getId_Contrato());

        assertEquals(contrato,contratoPersistido);
    }

    @Test
    public void PersistirUmContratoDeDemandaTest(){
        contrato = new ContratoEntity();

        contrato.setConsumidor(usuariosDAL.getOne(11));
        contrato.setPrestador(usuariosDAL.getOne(10));
        contrato.setDemanda(demandasDAl.getOne(1));
        contrato.setAprovado_Consumidor(true);
        contrato.setAprovado_Prestador(true);
        contrato.setEndereco(enderecosDAL.getOne(11 ));
        contrato.setPago(true);
        contrato.setValor_Final(00.00);

        contratosDAL.save(contrato);

        ContratoEntity contratoPersistido = contratosDAL.getOne(contrato.getId_Contrato());

        assertEquals(contrato,contratoPersistido);
    }

    @Test
    public void buscarTodosContratosTest(){
        List<ContratoEntity> contratos = contratosDAL.findAll();

        assertFalse(contratos.isEmpty());
    }
}
