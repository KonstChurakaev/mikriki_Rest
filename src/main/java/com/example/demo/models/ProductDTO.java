package com.example.demo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Schema(name = "Product", description = "Сущность товара")
public class ProductDTO {

    @Schema(description = "Тип повара")
    private String type;

    @Schema(description = "Описание товара")
    private String description;

    @Schema(description = "Цена товара")
    private BigDecimal price;
}
