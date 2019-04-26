package br.com.Bandtec.RavenCrown.Infra.Business;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityApplication {

    public SecurityApplication(List<UsuarioEntity> users){
        this.userCredencial = users;
    }

    private final List<UsuarioEntity> userCredencial;

    public boolean doLogin(UsuarioEntity usuarioEntity){
        boolean retorno = false;

        for(UsuarioEntity x : this.userCredencial){
            if(x.getEmail_Usuario().equalsIgnoreCase(usuarioEntity.getEmail_Usuario())
            && x.getSenha().equalsIgnoreCase(usuarioEntity.getSenha())){
                new LogBussines().logLoginHistory(usuarioEntity);
                retorno = true;
            }
        };
        return retorno;
    }

}
