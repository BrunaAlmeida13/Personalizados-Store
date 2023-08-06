package api.personalizadostore.controledeestoquemateriais.domain.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record MaterialDto(

        @NotBlank
        String nome,

        String cor,
        String descricao,

        @NotNull
        @PositiveOrZero(message = "{numeroNegativo.invalido}")
        @Digits(integer = 10, fraction = 0)
        int quantidadeEmEstoque,

        @NotNull
        @PositiveOrZero(message = "{numeroNegativo.invalido}")
        BigDecimal preco,

        @NotNull
        Long categoriaId
) {
}
