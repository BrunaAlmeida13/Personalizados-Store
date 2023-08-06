package api.personalizadostore.controledeestoquemateriais.controller.impl;

import api.personalizadostore.controledeestoquemateriais.controller.CategoriaController;
import api.personalizadostore.controledeestoquemateriais.domain.dto.request.CategoriaDto;
import api.personalizadostore.controledeestoquemateriais.domain.dto.response.CategoriaDetalhadaDto;
import api.personalizadostore.controledeestoquemateriais.domain.entity.Categoria;
import api.personalizadostore.controledeestoquemateriais.domain.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/controle-de-estoque/categoria")
public class CategoriaControllerImpl implements CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Override
    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CategoriaDto dados, UriComponentsBuilder uriBuilder) {
        CategoriaDetalhadaDto categoriaDetalhadaDto = categoriaService.cadastrar(dados);

        var uri = uriBuilder.path("api/controle-de-estoque/categoria/{id}").buildAndExpand(categoriaDetalhadaDto.id()).toUri();

        return ResponseEntity.created(uri).body(categoriaDetalhadaDto);
    }

    @GetMapping("/listarCategorias")
    public ResponseEntity<Page<CategoriaDetalhadaDto>> listarCategorias(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return ResponseEntity.ok(categoriaService.listarCategorias(paginacao));
    }

    @GetMapping("/buscarCategoria/{id}")
    public ResponseEntity buscarCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(new CategoriaDetalhadaDto(categoriaService.buscarCategoriaPorId(id)));
    }
}
