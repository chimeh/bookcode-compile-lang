package com.TacoCloud.TacoCloud.Controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import com.TacoCloud.TacoCloud.Domain.Entities.Order;
import com.TacoCloud.TacoCloud.Repositories.OrderRepository;

/**
 * This is the controller for the orders mapping.
 */
@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Adds an attribute to the model and returns a view.
     *
     * @return The order form view with populated model.
     */
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    /**
     * When we submit the order we validate it using the Java beans API and
     * then return to the same page with errors (handled by Thymleaf). Otherwise
     * we redirect home.
     */
    @PostMapping()
    public String processOrder(@Valid Order order, Errors errors) {
        if(errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: " + order);
        return "redirect:/";
    }

}
