package com.nttdata.spring.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.spring.repository.Addressee;
import com.nttdata.spring.repository.AddresseeRepository;
import com.nttdata.spring.repository.Order;
import com.nttdata.spring.repository.OrderRepository;
import com.nttdata.spring.repository.Product;
import com.nttdata.spring.repository.ProductRepository;

/**
 * Servicio para pedidos fuera de la peninsula
 * 
 * @author Jose
 *
 */
@Service("outsidePeninsula")
public class DeliveryServiceCMCImpl implements DeliveryServiceI {

	/** LOGGER **/
	private static Logger log = LoggerFactory.getLogger(DeliveryServiceCMCImpl.class);

	@Autowired
	OrderRepository orderRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	AddresseeRepository addRepo;

	@Override
	public void createOrder(Order o) {
		orderRepo.save(o);
	}

	@Override
	public void insertProductToAnOrder(Order o, Product p, Addressee a) {

		if (o.isOutPeninsula()) {
			double tax = (p.getPriceNoTax() * 4) / 100;

			p.setPriceWithTax(p.getPriceNoTax() + tax);

			addRepo.save(a);

			p.setOrder(o);

			o.setAddressee(a);
			
			productRepo.save(p);

			orderRepo.save(o);

		} else {
			log.error("El pedido se hace dentro de la peninsula");
		}

	}

	@Override
	public Optional<Order> checkDataOrder(Long id) {
		return orderRepo.findById(id);

	}

	@Override
	public void breakDownOrder(Long id) {
		orderRepo.deleteById(id);
	}

}
