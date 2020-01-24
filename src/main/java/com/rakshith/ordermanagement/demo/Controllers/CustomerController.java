/**
 * @author Rakshith
 */

package com.rakshith.ordermanagement.demo.Controllers;

import com.rakshith.ordermanagement.demo.dao.UserSQL;
import com.rakshith.ordermanagement.demo.domain.User;
import com.rakshith.ordermanagement.demo.domain.Login;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    UserSQL userSQL = new UserSQL();

    @PostMapping(path = "/register", consumes = "application/json")
    public String customerRegistration(@RequestBody User user) {
        String output = userSQL.insertIntoUsers(user);
        System.out.println(user.toString());
        return output;
    }

    @GetMapping(path = "/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        String output = userSQL.checkLogin(userName, password);
        System.out.println(output);
        return output;

    }
}
