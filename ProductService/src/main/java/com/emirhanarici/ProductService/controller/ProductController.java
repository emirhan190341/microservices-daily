package com.emirhanarici.ProductService.controller;

import com.emirhanarici.ProductService.payload.request.ProductRequest;
import com.emirhanarici.ProductService.payload.response.ProductResponse;
import com.emirhanarici.ProductService.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest request) {

        long productId = productService.addProduct(request);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {



        ProductResponse productResponse
                = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

}
