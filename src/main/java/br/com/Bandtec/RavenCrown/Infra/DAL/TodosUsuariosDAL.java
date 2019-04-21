package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosUsuariosDAL extends JpaRepository<UsuarioEntity, Integer> {
}
