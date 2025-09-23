package br.com.fiap.gh.repositories;

import br.com.fiap.gh.entities.PermissaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {

}
