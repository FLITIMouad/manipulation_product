package com.api.products.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Product",uniqueConstraints =@UniqueConstraint(columnNames = {"name"}))
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String category;
    
    private int quantity;
    
    private Boolean status;

    
}
