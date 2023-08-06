package api.personalizadostore.controledeestoquemateriais.domain.dto.response;

import api.personalizadostore.controledeestoquemateriais.domain.entity.Categoria;

public record CategoriaDetalhadaDto(
        Long id,
        String nome,
        String descricao
) {
    public CategoriaDetalhadaDto(Categoria categoria) {
        this(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }
}
