/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.order;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.OrderDAO;
import org.pulem3t.crm.entry.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orders")
public class UpdateOrderController {
	
	protected static Logger logger = Logger.getLogger("UpdateOrderController");

	@Autowired
	private OrderDAO orderDAO;
	
	@RequestMapping(value="/updateOrder", method=RequestMethod.POST)
	public @ResponseBody String updateOrder(@RequestBody Order order) {
		
		logger.info("ORDERS: Update order with id=" + order.getId());
		
		try {
			orderDAO.updateOrder(order);
			return "Updated order with id = " + order.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
