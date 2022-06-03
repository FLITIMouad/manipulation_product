package com.api.products.config;

import java.util.List;
import com.api.products.Entity.Product;
import com.api.products.dto.ProductDto;


import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIoC = IoC.SPRING)
public interface ProductMapper {
  @Maps(withIgnoreMissing = IgnoreMissing.ALL)
    //clone product Dto to product entity
     Product asProduct(ProductDto product);

  //clone product entity to product Dto
    ProductDto asProductDto(Product product);


    List<ProductDto> asProductDtoList(List<Product> products);
}
