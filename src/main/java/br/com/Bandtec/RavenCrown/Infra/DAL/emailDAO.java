package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface emailDAO extends JpaRepository<UsuarioEntity, Integer> {

    @Query("FROM UsuarioEntity where id_usuario = ?1")
    ContratoEntity getID(int id_usuario);
}
