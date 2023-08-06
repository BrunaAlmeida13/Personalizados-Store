package api.personalizadostore.controledeestoquemateriais.domain.service;

import api.personalizadostore.controledeestoquemateriais.domain.dto.response.CategoriaDetalhadaDto;
import api.personalizadostore.controledeestoquemateriais.domain.dto.request.CategoriaDto;
import api.personalizadostore.controledeestoquemateriais.domain.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoriaService {

    CategoriaDetalhadaDto cadastrar(CategoriaDto dados);
    Page<CategoriaDetalhadaDto> listarCategorias(Pageable paginacao);
    Categoria buscarCategoriaPorId(Long id);
}
