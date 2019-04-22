package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosServicosDAL extends JpaRepository<ServicoEntity, Integer> {
}
