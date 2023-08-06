package api.personalizadostore.controledeestoquemateriais.controller;

import api.personalizadostore.controledeestoquemateriais.domain.dto.response.CategoriaDetalhadaDto;
import api.personalizadostore.controledeestoquemateriais.domain.dto.request.CategoriaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

public interface CategoriaController {

    ResponseEntity cadastrar(CategoriaDto dados, UriComponentsBuilder uriBuilder);
    ResponseEntity<Page<CategoriaDetalhadaDto>> listarCategorias(Pageable paginacao);
    ResponseEntity buscarCategoria(Long id);

}
