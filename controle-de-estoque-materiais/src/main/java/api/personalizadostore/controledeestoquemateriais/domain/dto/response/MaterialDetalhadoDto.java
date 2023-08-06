package api.personalizadostore.controledeestoquemateriais.domain.dto.response;

import api.personalizadostore.controledeestoquemateriais.domain.entity.Material;

import java.math.BigDecimal;

public record MaterialDetalhadoDto(
        Long id,
        String nome,
        String cor,
        String descricao,
        int quantidadeEmEstoque,
        BigDecimal preco,
        CategoriaDetalhadaDto categoriaDetalhada
) {

    public MaterialDetalhadoDto(Material material) {
        this(material.getId(), material.getNome(), material.getCor(), material.getDescricao(),
                material.getQuantidadeEmEstoque(), material.getPreco(), new CategoriaDetalhadaDto(material.getCategoria()));
    }

    public MaterialDetalhadoDto(MaterialDetalhadoDto materialDetalhadoDto) {
        this(materialDetalhadoDto.id(), materialDetalhadoDto.nome(), materialDetalhadoDto.cor(), materialDetalhadoDto.descricao(),
                materialDetalhadoDto.quantidadeEmEstoque(), materialDetalhadoDto.preco(), materialDetalhadoDto.categoriaDetalhada());
    }
}
