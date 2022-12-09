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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

/**
 * Clase Pedido
 * 
 * @author Jose
 *
 */
@Entity
@Table(name = "T_ORDER")
public class Order extends AbstractEntity implements Serializable {

	/** Serial Version **/
	private static final long serialVersionUID = 1L;

	/** Productos asociados **/
	private List<Product> products;

	/** Identificador (PK) */
	private Long orderId;

	/** Destinatario (FK) **/
	private Addressee addresseeId;

	/** Direccion **/
	private String address;

	/** Indicador fuera de la peninsula **/
	private boolean outPeninsula;

	/**
	 * Devuelve el id del pedido
	 * 
	 * @return orderId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * Coloca el id del pedido
	 * 
	 * @param orderId (pedidoId)
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * Devuelve los productos asociados
	 * 
	 * @return products
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Coloca los productos asociados
	 * 
	 * @param products (productos)
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	/**
	 * Devuelve la direccion
	 * 
	 * @return address
	 */
	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	/**
	 * Coloca la direccion
	 * 
	 * @param address (direccion)
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Devuelve si esta fuera de la peninsula
	 * 
	 * @return outPeninsula
	 */
	@Column(name = "OUT_PENINSULA")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public boolean isOutPeninsula() {
		return outPeninsula;
	}

	/**
	 * Coloca si esta fuera de la peninsula
	 * 
	 * @param outPeninsula (fueraPeninsula)
	 */
	public void setOutPeninsula(boolean outPeninsula) {
		this.outPeninsula = outPeninsula;
	}

	/**
	 * Devuelve el destinatario asociado
	 * 
	 * @return addresseId
	 */
	@ManyToOne
	@JoinColumn(name = "ADDRESSEE_ID", nullable = true)
	public Addressee getAddressee() {
		return addresseeId;
	}

	/**
	 * Coloca el destinatario asociado
	 * 
	 * @param addresseeId (destinatarioId)
	 */
	public void setAddressee(Addressee addresseeId) {
		this.addresseeId = addresseeId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", addresseeId=" + addresseeId + ", address=" + address + ", outPeninsula="
				+ outPeninsula + "]";
	}

	/**
	 * Devuelve el nombre de la clase
	 * 
	 * @return Class
	 */
	@Transient
	public Class<?> getClase() {
		return Order.class;
	}

}
