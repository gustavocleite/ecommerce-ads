package com.sale.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;



@Data
@MappedSuperclass
public class BaseModel {
    @Id
    protected Integer id;
}
