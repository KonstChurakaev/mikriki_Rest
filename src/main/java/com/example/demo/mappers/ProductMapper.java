package com.example.demo.mappers;

import com.example.demo.models.Product;
import com.example.demo.models.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toListProductsDTO(List<Product> products);

    Product toProduct(ProductDTO productDTO);

}
