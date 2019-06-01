package br.com.Bandtec.RavenCrown.BusinessTest;


import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Infra.Business.EnderecoBussiness;
import br.com.Bandtec.RavenCrown.Infra.Business.UsuarioBusiness;
import br.com.Bandtec.RavenCrown.Infra.DAL.TodosEnderecosDAL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class EnderecoBusinessTest {

    @Autowired
    EnderecoBussiness enderecoBussiness;

    @Autowired
    TodosEnderecosDAL enderecosDAL;

    @Autowired
    UsuarioBusiness userBusiness;

    private EnderecoEntity endereco;

    @Before
    public void SetUp(){
        endereco = new EnderecoEntity();
        endereco.setBairro("Lapa");
        endereco.setCep("00000-000");
        endereco.setRua("Rua da Lapa");
        endereco.setCidade("São Paulo");
        endereco.setComplemento("Predio Azul");
        endereco.setNumero("302");
        endereco.setPais("Brazil");
        endereco.setEstado("SP");
        endereco.setUsuario(userBusiness.getUser(11));

        endereco = enderecosDAL.save(endereco);
    }

    @Test
    public void AtualizarUmEndereco(){
        endereco.setBairro("Mooca");
        endereco.setCep("00000-111");
        endereco.setRua("Rua da Mooca");
        endereco.setCidade("São Arnaldo");
        endereco.setComplemento(null);
        endereco.setNumero("111");
        endereco.setPais("Estados Unidos do Brasil");
        endereco.setEstado("RS");

        assertTrue(enderecoBussiness.UpdateEndereco(endereco));
    }

    @Test
    public void ObterEndereco(){
        EnderecoEntity enderecoObtido = enderecoBussiness.GetEndereco(endereco.getId_Endereco());
        assertEquals(enderecoObtido,endereco);
    }


}
