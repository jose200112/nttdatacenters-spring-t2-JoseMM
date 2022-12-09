package com.nttdata.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de productos
 * 
 * @author Jose
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
