package com.cydeo.controller;

import com.cydeo.service.CartService;
import com.cydeo.service.impl.CartServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@AllArgsConstructor
@Controller
public class CartController {



    private CartService cartService;

    @GetMapping("/cart")
    public String getCartPage(Model model){
        model.addAttribute("cart", CartServiceImpl.CART);

        return "cart/show-cart";
    }


    @GetMapping("/addToCart/{productId}/{quantity}")
    public String addToCart( @PathVariable("productId") UUID productId, @PathVariable("quantity") int quantity){

       cartService.addToCart(productId, quantity);

       return "redirect:/cart";
    }




    @GetMapping("/delete/{productId}")
    public String deleteCart(@PathVariable("productId") UUID productId ){
        cartService.deleteFromCart(productId);


        return "redirect:/cart";
    }

}
