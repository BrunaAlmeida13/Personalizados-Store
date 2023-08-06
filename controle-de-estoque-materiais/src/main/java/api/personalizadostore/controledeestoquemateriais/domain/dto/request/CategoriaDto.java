package api.personalizadostore.controledeestoquemateriais.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Value;

public record CategoriaDto(
        @NotBlank
        @Value("#{target.nome.toUpperCase()}")
        @Pattern(regexp = "^MATERIAL_.*$", message = "{nomeCategoria.invalido}")
        String nome,

        String descricao
) {
}
