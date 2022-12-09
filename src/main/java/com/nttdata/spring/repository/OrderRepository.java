package com.nttdata.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de pedidos
 * 
 * @author Jose
 *
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
