package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Entity.ContratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosContratosDAL  extends JpaRepository<ContratoEntity,Integer> {
}
