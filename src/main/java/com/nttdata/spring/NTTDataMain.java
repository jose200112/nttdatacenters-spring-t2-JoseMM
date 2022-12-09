package com.nttdata.spring;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.repository.Addressee;
import com.nttdata.spring.repository.Order;
import com.nttdata.spring.repository.Product;
import com.nttdata.spring.services.DeliveryServiceI;

/**
 * Clase principal
 * 
 * @author Jose
 *
 */
@SpringBootApplication()
public class NTTDataMain implements CommandLineRunner {

	/** LOGGER **/
	private static Logger log = LoggerFactory.getLogger(NTTDataMain.class);

	/** Servicios **/
	@Autowired
	@Qualifier("insidePeninsula")
	private DeliveryServiceI deliveryService1;

	@Autowired
	@Qualifier("outsidePeninsula")
	private DeliveryServiceI deliveryService2;

	/**
	 * Metodo principal
	 * 
	 * @param args (main)
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Creacion de pedidos
		Order order1 = new Order();
		order1.setAddress("Av. del Aljarafe, C-2 5º P-4");
		order1.setOutPeninsula(false);

		Order order2 = new Order();
		order2.setAddress("Calle verde, N-3");
		order2.setOutPeninsula(true);

		Order order3 = new Order();
		order3.setAddress("Calle rojo, C-2 2º P-2");
		order3.setOutPeninsula(true);

		// Insercion del pedido
		deliveryService1.createOrder(order1);
		deliveryService2.createOrder(order2);
		deliveryService1.createOrder(order3);

		// Creacion de productos
		Product product1 = new Product();
		product1.setName("portatil");
		product1.setPriceNoTax(500.00);

		Product product2 = new Product();
		product2.setName("movil");
		product2.setPriceNoTax(600.00);

		// Creacion de destinatario
		Addressee add1 = new Addressee();
		add1.setDni("74538432R");
		add1.setName("Lucia");
		add1.setSurnames("Perez Garcia");

		Addressee add2 = new Addressee();
		add2.setDni("45832345T");
		add2.setName("Manuel");
		add2.setSurnames("Gonzalez Sanchez");

		// Inserciones de destinatarios y productos
		deliveryService1.insertProductToAnOrder(order1, product1, add1);
		deliveryService2.insertProductToAnOrder(order2, product2, add2);

		// Separador
		log.info("--------------------------------------------------");

		// Ejemplo de insercion con servicio equivocado (pedido fuera de la peninsula)
		deliveryService1.insertProductToAnOrder(order3, product2, add2);

		// Borrado de pedido
		deliveryService1.breakDownOrder(3L);

		// Comprueba los datos del pedido
		Optional<Order> data = deliveryService1.checkDataOrder(1L);
		if (data.isPresent()) {
			log.info("Datos del pedido con id 1: {}", data.get());
		}

	}

}
