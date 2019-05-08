package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityApplication {

    private final List<UsuarioEntity> userCredencial;

    public SecurityApplication(List<UsuarioEntity> users){
        this.userCredencial = users;
    }

    public int doLogin(UsuarioEntity usuarioEntity){
        int retorno = -1;

        for (int i = 0; i < this.userCredencial.size(); i++ ){
            if(this.userCredencial.get(i).getEmail_Usuario().equalsIgnoreCase(usuarioEntity.getEmail_Usuario())
            && this.userCredencial.get(i).getSenha().equalsIgnoreCase(usuarioEntity.getSenha())){
                new LogBussines().logLoginHistory(usuarioEntity);
                retorno = i;
                break;
            }
        };
        return retorno;
    }

}
