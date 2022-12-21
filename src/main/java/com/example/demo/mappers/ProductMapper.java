package com.example.demo.mappers;

import com.example.demo.models.Product;
import com.example.demo.models.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO productToProductDTO(Product product);

    List<ProductDTO> productsToProductsDTO(List<Product> products);

}
