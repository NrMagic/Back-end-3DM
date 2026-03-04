package com.example.ecommerce.service;

import com.example.ecommerce.entity.ProductEntity;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.dto.ProductRequestDTO;
import com.example.ecommerce.dto.ProductResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SuppressWarnings("unused")
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productReq){
        if(productReq == null){
            throw new IllegalArgumentException("os dados inseridos são inválidos");
        }
        if(productRepository.findByName(productReq.getName()).isPresent()){
            throw new DuplicateKeyException("Já existe um produto com esse nome");
        }

        ProductEntity newProd = new ProductEntity(productReq.getName(), productReq.getDescription(),productReq.getPrice(),productReq.getImgURL());
        productRepository.save(newProd);
        return new ProductResponseDTO(newProd.getName(), newProd.getDescription(), newProd.getPrice());
    }

    public ProductResponseDTO showProductById(Long id){
        ProductEntity prod = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("não existe um produto com esse id: " + id));
        return new ProductResponseDTO(prod.getName(), prod.getDescription(), prod.getPrice());
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO proReq){
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("não existe um usuário com esse id"));

        productEntity.setName(proReq.getName());
        productEntity.setDescription(proReq.getDescription());
        productEntity.setPrice(proReq.getPrice());
        productEntity.setImgURL(proReq.getImgURL());

        ProductEntity updatedProduct = productRepository.save(productEntity);

        return new ProductResponseDTO(updatedProduct.getName(), updatedProduct.getDescription(), updatedProduct.getPrice());
    }

    public void deleteProduct(Long id){
        productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("não existe um produto com esse id"));
        productRepository.deleteById(id);
    }
}
