/**
 * @author Rakshith
 */

package com.rakshith.ordermanagement.demo.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rakshith.ordermanagement.demo.dao.StockSQL;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stocks")
public class StocksController {
    StockSQL stockSQL = new StockSQL();
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(path = "/allStocks")
    public String getAllStocks(){
        try {
            return objectMapper.writeValueAsString(stockSQL.getAllStocks());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(path = "/changeStockStatus")
    public String changeStockStatus(@RequestParam("stockName") String stockName,
                                    @RequestParam("stockValue") String stockValue){
        String result = null;
        try{
      result =  stockSQL.updateStockStatus(stockName,stockValue);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
