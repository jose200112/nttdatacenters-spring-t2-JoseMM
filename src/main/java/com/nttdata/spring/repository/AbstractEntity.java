package com.nttdata.spring.repository;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * Clase abstracta
 * 
 * @author Jose
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

}
