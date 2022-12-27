package com.example.demo.services.implementation;

import com.example.demo.exception_handling.NoSuchProductException;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {

        List<Product> products = productRepository.findAll();
        if ((products == null) || (products.isEmpty())) {
            throw new NoSuchProductException("No product found in Database");
        }
        return products;
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductById(long id) {
        Product product = productRepository.findProductById(id);
        if (product == null) {
            throw new NoSuchProductException("There is no product with ID = " + id + " in Database");
        }
        return product;
    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        Product oldProduct = productRepository.findProductById(product.getId());
        if (oldProduct == null) {
            throw new NoSuchProductException("There is no product with ID = " + product.getId() + " in Database");
        }
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProductById(long id) {
        if (productRepository.findProductById(id) == null) {
            throw new NoSuchProductException("There is no product with ID = " + id + " in Database");
        }
        productRepository.deleteById(id);
    }
}
