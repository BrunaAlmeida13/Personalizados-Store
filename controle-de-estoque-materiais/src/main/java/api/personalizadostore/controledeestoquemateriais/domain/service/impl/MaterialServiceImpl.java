package api.personalizadostore.controledeestoquemateriais.domain.service.impl;

import api.personalizadostore.controledeestoquemateriais.domain.dto.request.MaterialDto;
import api.personalizadostore.controledeestoquemateriais.domain.dto.response.MaterialDetalhadoDto;
import api.personalizadostore.controledeestoquemateriais.domain.entity.Categoria;
import api.personalizadostore.controledeestoquemateriais.domain.entity.Material;
import api.personalizadostore.controledeestoquemateriais.domain.repository.CategoriaRepository;
import api.personalizadostore.controledeestoquemateriais.domain.repository.MaterialRepository;
import api.personalizadostore.controledeestoquemateriais.domain.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public MaterialDetalhadoDto cadastrar(MaterialDto dados) {
        Material material = new Material(dados);

        Categoria categoria = categoriaRepository.findById(material.getCategoria().getId()).get();

        material.setCategoria(categoria);
        MaterialDetalhadoDto materialSalvo = new MaterialDetalhadoDto(materialRepository.save(material));

        return materialSalvo;
    }

    @Override
    public Page<MaterialDetalhadoDto> listarMateriais(Pageable paginacao) {
        return materialRepository.findAllByOrderByQuantidadeEmEstoqueDescNomeAsc(paginacao).map(MaterialDetalhadoDto::new);
    }

    @Override
    public Material buscarMaterialPorId(Long id) {
        return materialRepository.findById(id).get();
    }

}
