package api.personalizadostore.controledeestoquemateriais.controller.impl;

import api.personalizadostore.controledeestoquemateriais.controller.MaterialController;
import api.personalizadostore.controledeestoquemateriais.domain.dto.response.MaterialDetalhadoDto;
import api.personalizadostore.controledeestoquemateriais.domain.dto.request.MaterialDto;
import api.personalizadostore.controledeestoquemateriais.domain.service.MaterialService;
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
@RequestMapping("api/controle-de-estoque/material")
public class MaterialControllerImpl implements MaterialController {

    @Autowired
    private MaterialService materialService;

    @Override
    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid MaterialDto dados, UriComponentsBuilder uriBuilder) {
        MaterialDetalhadoDto materialDetalhadoDto = materialService.cadastrar(dados);

        var uri = uriBuilder.path("api/controle-de-estoque/material/{id}").buildAndExpand(materialDetalhadoDto.id()).toUri();


        return ResponseEntity.created(uri).body(materialDetalhadoDto);
    }

    @GetMapping("/listarMateriais")
    public ResponseEntity<Page<MaterialDetalhadoDto>> listarMateriais(@PageableDefault(size = 10) Pageable paginacao) {
        return ResponseEntity.ok(materialService.listarMateriais(paginacao));
    }

    @GetMapping("buscarMaterial/{id}")
    public ResponseEntity buscarMaterial(@PathVariable Long id) {
        return ResponseEntity.ok(new MaterialDetalhadoDto(materialService.buscarMaterialPorId(id)));
    }


}
