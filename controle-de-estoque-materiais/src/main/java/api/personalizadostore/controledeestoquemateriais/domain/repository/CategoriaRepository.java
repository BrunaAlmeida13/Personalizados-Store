package api.personalizadostore.controledeestoquemateriais.domain.repository;

import api.personalizadostore.controledeestoquemateriais.domain.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
   Page<Categoria> findAllByOrderByNomeAsc(Pageable paginacao);
}
