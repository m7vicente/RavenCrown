package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosServicosDAL extends JpaRepository<ServicoEntity, Integer> {

    @Query("from servicoEntity where id_prestador = ?1")
    List<ServicoEntity> GetAllServicesByUserId(int id);

}
