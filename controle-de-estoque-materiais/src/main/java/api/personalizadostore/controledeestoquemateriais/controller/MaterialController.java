package api.personalizadostore.controledeestoquemateriais.controller;

import api.personalizadostore.controledeestoquemateriais.domain.dto.request.MaterialDto;
import api.personalizadostore.controledeestoquemateriais.domain.dto.response.CategoriaDetalhadaDto;
import api.personalizadostore.controledeestoquemateriais.domain.dto.response.MaterialDetalhadoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

public interface MaterialController {

    ResponseEntity cadastrar(MaterialDto dados, UriComponentsBuilder uriBuilder);
    ResponseEntity buscarMaterial(Long id);
    ResponseEntity<Page<MaterialDetalhadoDto>> listarMateriais(Pageable paginacao);
}
