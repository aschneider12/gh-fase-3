package br.com.fiap.gh.jpa.repositories;

import br.com.fiap.gh.jpa.entities.PermissaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {

}
