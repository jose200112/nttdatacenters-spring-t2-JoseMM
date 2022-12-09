package com.nttdata.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de destinatarios
 *
 * @author Jose
 *
 */
@Repository
public interface AddresseeRepository extends JpaRepository<Addressee, Long> {

}
