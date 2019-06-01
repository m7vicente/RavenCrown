package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Entity.ImagemServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosImagemServicoDAL extends JpaRepository<ImagemServicoEntity,Integer> {

    @Query("from ImagemServicoEntity where Id_servico = ?1")
    List<ImagemServicoEntity> GetAllByServiceId(int id);
}
