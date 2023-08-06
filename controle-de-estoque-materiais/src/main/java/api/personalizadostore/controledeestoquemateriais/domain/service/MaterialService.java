package api.personalizadostore.controledeestoquemateriais.domain.service;

import api.personalizadostore.controledeestoquemateriais.domain.dto.response.MaterialDetalhadoDto;
import api.personalizadostore.controledeestoquemateriais.domain.dto.request.MaterialDto;
import api.personalizadostore.controledeestoquemateriais.domain.entity.Material;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MaterialService {

    MaterialDetalhadoDto cadastrar(MaterialDto dados);

    Material buscarMaterialPorId(Long id);

    Page<MaterialDetalhadoDto> listarMateriais(Pageable paginacao);
}
