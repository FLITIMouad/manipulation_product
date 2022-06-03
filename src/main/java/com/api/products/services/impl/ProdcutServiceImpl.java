package com.api.products.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.api.products.Entity.Product;
import com.api.products.Models.ExceptionBadReq;
import com.api.products.Models.ExceptionDuplicate;
import com.api.products.config.ProductMapper;
import com.api.products.dao.ProductRepository;
import com.api.products.services.api.ProductService;

import com.api.products.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import fr.xebia.extras.selma.Selma;

@Service
public class ProdcutServiceImpl implements ProductService {

    @Autowired
    ProductRepository repo;

    @Bean
    private ProductMapper productMapper()
    {
        return Selma.builder(ProductMapper.class).build();
    };
    
// Get all products from Entity
    public List<ProductDto> getProducts() {
        //Clone Result list of Entity product  to list of product Dto and retutn it
        return productMapper().asProductDtoList(repo.findAll());
    }

   

    // Get All product by status field
    public List<ProductDto> getProductsByStatus(Boolean status) {
        //Clone Result list of Entity product  to list of product Dto and retutn it
        return productMapper().asProductDtoList(repo.findByStatus(status));
    }


    // Create New Product
    public ProductDto createProduct(ProductDto productdto) throws ExceptionBadReq, ExceptionDuplicate {
        //Throws Exception if Quantity is less than zero
        if(productdto.getQuantity()<1)
        {
            throw new ExceptionBadReq("Quantity must be greater than zero");
        }

        //Clone product Dto Request to product Entity 
        Product product = productMapper().asProduct(productdto);
        //Clone Result product Entity to product Dto and retutn it
        try{
            return  productMapper().asProductDto(repo.saveAndFlush(product));
        } catch (Exception e) {
            
            throw new ExceptionDuplicate(e.getMessage().indexOf("Unique") >-1?"Product must be unique":e.getMessage());
        }
        
    }

    public void deleteProduct(Long id) throws ExceptionBadReq {
        Product product = repo.getById(id) ;
        if (product== null)
        {
            throw new ExceptionBadReq("Product not found");
        }
        repo.delete(product);
    }

    public ProductDto updateProduct(ProductDto productdto) throws ExceptionBadReq {
        Long id = productdto.getId();
        if (repo.getById(id)== null)
        {
            throw new ExceptionBadReq("Product not found");
        }
        Product product = productMapper().asProduct(productdto);
        return productMapper().asProductDto(repo.save(product));
    }
    
}
