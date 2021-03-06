package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Entity.ImagemUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosImagemUsuairoDAL extends JpaRepository<ImagemUsuarioEntity,Integer> {

    @Query("from ImagemUsuarioEntity where id_usuario = ?1")
    ImagemUsuarioEntity GetImagemByUser(int Id_usuario);

}
