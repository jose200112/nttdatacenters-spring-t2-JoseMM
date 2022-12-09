package com.nttdata.spring.services;

import java.util.Optional;

import com.nttdata.spring.repository.Addressee;
import com.nttdata.spring.repository.Order;
import com.nttdata.spring.repository.Product;

/**
 * Interfaz de servicios
 * 
 * @author Jose
 *
 */
public interface DeliveryServiceI {

	/**
	 * Crea un pedido y lo inserta
	 * 
	 * @param o (pedido)
	 */
	public void createOrder(Order o);

	/**
	 * Inserta un producto y un destinatario al pedido
	 * 
	 * @param o (pedido)
	 * @param p (producto)
	 * @param a (destinatario)
	 */
	public void insertProductToAnOrder(Order o, Product p, Addressee a);

	/**
	 * Devuelve los datos del pedido
	 * 
	 * @param id (id)
	 * @return Optional
	 */
	public Optional<Order> checkDataOrder(Long id);

	/**
	 * Borra un pedido
	 * 
	 * @param id (id)
	 */
	public void breakDownOrder(Long id);

}
