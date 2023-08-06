package api.personalizadostore.controledeestoquemateriais.domain.entity;

import api.personalizadostore.controledeestoquemateriais.domain.dto.request.MaterialDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "Material")
@Table(name = "materiais")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cor;
    private String descricao;
    private int quantidadeEmEstoque;

    @Column(precision = 10, scale = 2)
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Material (MaterialDto dados) {
        this.nome = dados.nome();
        this.cor = dados.cor();
        this.descricao = dados.descricao();
        this.quantidadeEmEstoque = dados.quantidadeEmEstoque();
        this.preco = dados.preco();
        this.categoria = new Categoria();
        this.categoria.setId(dados.categoriaId());
    }
}
