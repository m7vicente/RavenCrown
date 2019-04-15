package br.com.Bandtec.RavenCrown.EntityTest;

import br.com.Bandtec.RavenCrown.Entity.EnderecoEntity;
import br.com.Bandtec.RavenCrown.Infra.DAL.EnderecoDAL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.Console;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class EnderecoDALTest {

    @Autowired
    private EnderecoDAL enderecoDAL;

    @Test
    public void getAdress(){
        EnderecoEntity endereco = enderecoDAL.getOne(11);
        assertTrue( endereco.getId_Endereco() == 11 );
    }

}
