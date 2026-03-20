package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.ProductRequestDTO;
import com.example.ecommerce.dto.ProductResponseDTO;
import com.example.ecommerce.entity.ProductEntity;
import com.example.ecommerce.repository.ProductRepository;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgURL(dto.getImgURL());

        ProductEntity saved = productRepository.save(entity);

        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setDescription(saved.getDescription());
        response.setPrice(saved.getPrice());
        response.setImgURL(saved.getImgURL());

        return response;
    }

    public ProductResponseDTO showProductById(Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setImgURL(product.getImgURL());

        return response;
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImgURL(dto.getImgURL());

        ProductEntity updated = productRepository.save(product);

        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(updated.getId());
        response.setName(updated.getName());
        response.setDescription(updated.getDescription());
        response.setPrice(updated.getPrice());
        response.setImgURL(updated.getImgURL());

        return response;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
