package api.personalizadostore.controledeestoquemateriais.domain.repository;

import api.personalizadostore.controledeestoquemateriais.domain.dto.response.MaterialDetalhadoDto;
import api.personalizadostore.controledeestoquemateriais.domain.entity.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    Page<Material> findAllByOrderByQuantidadeEmEstoqueDescNomeAsc(Pageable paginacao);
}
