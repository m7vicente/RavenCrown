package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosUsuariosDAL extends JpaRepository<UsuarioEntity, Integer> {

    @Query("from UsuarioEntity where Email_Usuario = ?1 and Senha = ?2")
    public UsuarioEntity getByUserAndPass(String email, String senha);

    @Query("from UsuarioEntity where Email_Usuario = ?1")
    public UsuarioEntity getByEmail(String email);

}
