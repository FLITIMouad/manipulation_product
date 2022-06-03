package com.api.products.services.api;

import java.util.List;

import com.api.products.Models.ExceptionBadReq;
import com.api.products.Models.ExceptionDuplicate;
import com.api.products.dto.ProductDto;

public interface ProductService {
    List<ProductDto> getProducts();

    List<ProductDto> getProductsByStatus(Boolean status);

    ProductDto createProduct(ProductDto productdto) throws ExceptionBadReq, ExceptionDuplicate;

    void deleteProduct(Long id) throws ExceptionBadReq;

    ProductDto updateProduct(ProductDto productdto) throws ExceptionBadReq;
    
    
}
