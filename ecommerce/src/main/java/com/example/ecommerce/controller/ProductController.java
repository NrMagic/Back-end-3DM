package com.example.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.ProductRequestDTO;
import com.example.ecommerce.dto.ProductResponseDTO;
import com.example.ecommerce.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){this.productService = productService;}

    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO prodReq){
        ProductResponseDTO prodRes =  productService.createProduct(prodReq);
        return ResponseEntity.ok(prodRes);
    }
    @GetMapping("/show/id/{id}")
    public ResponseEntity<ProductResponseDTO> showById(@PathVariable Long id){
        ProductResponseDTO productDTO = productService.showProductById(id);
        return ResponseEntity.ok(productDTO);
    }
    @PutMapping("/update/id/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@Valid @PathVariable Long id, @RequestBody ProductRequestDTO prodReq){
        ProductResponseDTO updatedProduct = productService.updateProduct(id, prodReq);
        return ResponseEntity.ok(updatedProduct);
    }
    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("produto deletado com sucesso!");
    }
}
