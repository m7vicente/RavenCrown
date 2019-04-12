package br.com.Bandtec.RavenCrown.Infra.DAL;

import br.com.Bandtec.RavenCrown.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAL extends JpaRepository<UserEntity, Integer> {
}
