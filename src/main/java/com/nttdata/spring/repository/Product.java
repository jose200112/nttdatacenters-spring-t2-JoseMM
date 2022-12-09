package com.nttdata.spring.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase Producto
 * 
 * @author Jose
 *
 */
@Entity
@Table(name = "T_PRODUCT")
public class Product extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long productId;

	/** Pedido asociado (FK) **/
	private Order orderId;

	/** Nombre **/
	private String name;

	/** Precio PVP **/
	private Double priceWithTax;

	/** Precio sin impuestos **/
	private Double priceNoTax;

	/**
	 * Devuelve el id del producto
	 * 
	 * @return productId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	public Long getProductId() {
		return productId;
	}

	/**
	 * Coloca el id del producto
	 * 
	 * @param productId (productoId)
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
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
	 * Devuelve el precio con impuesto
	 * 
	 * @return priceWithTax
	 */
	@Column(name = "PRICE_WITH_TAX", nullable = true)
	public Double getPriceWithTax() {
		return priceWithTax;
	}

	/**
	 * Coloca el precio con impuesto
	 * 
	 * @param priceWithTax price
	 */
	public void setPriceWithTax(Double priceWithTax) {
		this.priceWithTax = priceWithTax;
	}

	/**
	 * Devuelve al precio sin impuesto
	 * 
	 * @return priceNoTax
	 */
	@Column(name = "PRICE_NO_TAX")
	public Double getPriceNoTax() {
		return priceNoTax;
	}

	/**
	 * Coloca el precio con impuesto
	 * 
	 * @param priceNoTax (precioSinImpuesto)
	 */
	public void setPriceNoTax(Double priceNoTax) {
		this.priceNoTax = priceNoTax;
	}

	/**
	 * Devuelve el pedido asociado
	 * 
	 * @return orderId
	 */
	@ManyToOne
	@JoinColumn(name = "ORDER_ID", nullable = true)
	public Order getOrder() {
		return orderId;
	}

	/**
	 * Coloca el pedido asociado
	 * 
	 * @param orderId (pedidoId)
	 */
	public void setOrder(Order orderId) {
		this.orderId = orderId;
	}

	/**
	 * Devuelve el nombre de la clase
	 * 
	 * @return Class
	 */
	@Transient
	public Class<?> getClase() {
		return Product.class;
	}

}
