package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Entity.DemandaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosDemandasDAL extends JpaRepository<DemandaEntity,Integer> {
}
