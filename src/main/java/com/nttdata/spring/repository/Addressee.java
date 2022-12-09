package com.nttdata.spring.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase Destinatario
 * 
 * @author Jose
 *
 */
@Entity
@Table(name = "T_ADDRESSEE")
public class Addressee extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long addresseeId;

	/** Pedidos asociados **/
	private List<Order> orders;

	/** Dni **/
	private String dni;

	/** Nombre **/
	private String name;

	/** Apellidos **/
	private String surnames;

	/**
	 * Devuelve el id del destinatario
	 * 
	 * @return addresseeId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESSEE_ID")
	public Long getAddresseeId() {
		return addresseeId;
	}

	/**
	 * Coloca el id del destinatario
	 * 
	 * @param addresseeId (destinatarioId)
	 */
	public void setAddresseeId(Long addresseeId) {
		this.addresseeId = addresseeId;
	}

	/**
	 * Devuelve los pedidos asociados
	 * 
	 * @return orders
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "addressee")
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * Coloca los pedidos asociados
	 * 
	 * @param orders (pedidos)
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	/**
	 * Devuelve el dni
	 * 
	 * @return dni
	 */
	@Column(name = "DNI", nullable = false, unique = true)
	public String getDni() {
		return dni;
	}

	/**
	 * Coloca el dni
	 * 
	 * @param dni (dni)
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Devuelve el nombre
	 * 
	 * @return name
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * Coloca el nombre
	 * 
	 * @param name (nombre)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve los apellidos
	 * 
	 * @return surnames
	 */
	@Column(name = "SURNAMES")
	public String getSurnames() {
		return surnames;
	}

	/**
	 * Coloca los apellidos
	 * 
	 * @param surnames (apellidos)
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	/**
	 * Devuelve el nombre de la clase
	 * 
	 * @return Class
	 */
	@Transient
	public Class<?> getClase() {
		return Addressee.class;
	}
}
