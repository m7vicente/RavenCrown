package EntityTest;

import br.com.Bandtec.RavenCrown.Infra.DAL.UsuarioDAL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringRunner;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UsuarioDAL userDAL;

    @Test
    public void GetUsersTest(){
        userDAL.findAll();
    }

}
