package com.sale.ecommerce.repository;

import com.sale.ecommerce.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email,Integer> {
}
