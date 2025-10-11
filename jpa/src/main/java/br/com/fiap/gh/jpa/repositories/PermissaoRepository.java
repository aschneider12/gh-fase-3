package br.com.fiap.gh.jpa.repositories;

import br.com.fiap.gh.jpa.entities.PermissaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {

    Optional<PermissaoEntity> findByRecurso(String recurso);
}
