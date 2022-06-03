package com.api.products.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import com.api.products.Models.ExceptionBadReq;
import com.api.products.dto.ProductDto;
import com.api.products.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequestMapping("api/v1/products")
@RestController
public class ProductController {
    
    @Autowired
    ProductService serviceProd;

    @GetMapping
    public ResponseEntity<List<ProductDto>> get(@RequestParam(required = false) Boolean status) {
        return new ResponseEntity<>(status !=null?serviceProd.getProductsByStatus(status) : serviceProd.getProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) throws Exception {
            return new ResponseEntity<>(serviceProd.createProduct(productDto), HttpStatus.CREATED);     
    }
    
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String> delete(@PathVariable String Id) throws NumberFormatException, Exception {
            serviceProd.deleteProduct(Long.parseLong(Id));
            return new ResponseEntity<>("resource deleted successfully", HttpStatus.ACCEPTED);   
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) throws ExceptionBadReq {
       
            return new ResponseEntity<>(serviceProd.updateProduct(productDto), HttpStatus.ACCEPTED);
     
    }
}
