package api.personalizadostore.controledeestoquemateriais.domain.entity;

import api.personalizadostore.controledeestoquemateriais.domain.dto.request.CategoriaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Categoria")
@Table(name = "categorias")
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    public Categoria(CategoriaDto dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
    }
}
