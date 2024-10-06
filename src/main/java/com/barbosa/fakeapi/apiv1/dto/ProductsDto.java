package com.barbosa.fakeapi.apiv1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // (Opcional, dependendo da necessidade de ter um construtor completo)
@Builder
public class ProductsDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "title")
    private String nome;

    @JsonProperty(value = "price")
    private BigDecimal preco;

    @JsonProperty(value = "category")
    private String categoria;

    @JsonProperty(value = "description")
    private String descricao;

    @JsonProperty(value = "image")
    private String imagem;
}
