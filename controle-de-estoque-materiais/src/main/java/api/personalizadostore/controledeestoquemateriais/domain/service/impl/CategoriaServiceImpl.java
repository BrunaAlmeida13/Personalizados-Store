package api.personalizadostore.controledeestoquemateriais.domain.service.impl;

import api.personalizadostore.controledeestoquemateriais.domain.dto.request.CategoriaDto;
import api.personalizadostore.controledeestoquemateriais.domain.dto.response.CategoriaDetalhadaDto;
import api.personalizadostore.controledeestoquemateriais.domain.entity.Categoria;
import api.personalizadostore.controledeestoquemateriais.domain.repository.CategoriaRepository;
import api.personalizadostore.controledeestoquemateriais.domain.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaDetalhadaDto cadastrar(CategoriaDto dados) {
        return new CategoriaDetalhadaDto(categoriaRepository.save(new Categoria(dados)));
    }

    @Override
    public Page<CategoriaDetalhadaDto> listarCategorias(Pageable paginacao) {
        return categoriaRepository.findAllByOrderByNomeAsc(paginacao).map(CategoriaDetalhadaDto::new);
    }

    @Override
    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).get();
    }


}
