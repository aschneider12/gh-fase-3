package br.com.fiap.gh.repositories;

import br.com.fiap.gh.entities.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {

}
