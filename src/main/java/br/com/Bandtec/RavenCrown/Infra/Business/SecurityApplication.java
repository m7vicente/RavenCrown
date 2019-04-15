package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class SecurityApplication {

    private String userCredencial [][] = new String [10][2];

    public SecurityApplication(){
        setRepository();
    }

    public boolean doLogin(UsuarioEntity usuarioEntity){

        for(int i = 0; i < userCredencial.length; i++){
            if(userCredencial[i][0].equalsIgnoreCase(usuarioEntity.getEmail_Usuario())
            && userCredencial[i][1].equalsIgnoreCase(usuarioEntity.getSenha())){
                new LogBussines().logLoginHistory(usuarioEntity);
                return true;
            }
        }
        return false;
    }

    private void setRepository(){
        userCredencial[0][0] = "email@gmail.com";
        userCredencial[0][1] = "senha";

        userCredencial[1][0] = "email@outlook.com";
        userCredencial[1][1] = "senha";

        userCredencial[2][0] = "email@hotmail.com";
        userCredencial[2][1] = "senha";

        userCredencial[3][0] = "email@live.com";
        userCredencial[3][1] = "senha";

        userCredencial[4][0] = "email@bol.out.com.br";
        userCredencial[4][1] = "senha";

        userCredencial[5][0] = "email@yahoo.com";
        userCredencial[5][1] = "senha";

        userCredencial[6][0] = "email@uol.com";
        userCredencial[6][1] = "senha";

        userCredencial[7][0] = "email@iclound.com";
        userCredencial[7][1] = "senha";

        userCredencial[8][0] = "email@duckduckgo.com";
        userCredencial[8][1] = "senha";

        userCredencial[9][0] = "email@terra.com.gr";
        userCredencial[9][1] = "senha";
    }

}
