/**
 * @author Rakshith
 */

package com.rakshith.ordermanagement.demo.Controllers;

import com.rakshith.ordermanagement.demo.dao.OrderPaymentSQL;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orderPayment")
public class OrderPaymentController {
    OrderPaymentSQL orderPaymentSQL = new OrderPaymentSQL();

    @RequestMapping("/placeOrder")
    public String placeOrder(@RequestParam("userName") String userName,
                           @RequestParam("stockCost") String stockCost,
                           @RequestParam("stockId") String stockId){

        orderPaymentSQL.placeOrder(userName,stockCost,stockId);

        return "success";

    }
}
