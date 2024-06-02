package com.cydeo.controller;

import com.cydeo.model.Product;
import com.cydeo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String retrieveList(Model model){

        model.addAttribute("productlist",productService.listProducts());
    return "product/list";}



    @GetMapping("/create-form")
    public String getCreateForm(Model model){

        Product product = new Product();
        model.addAttribute("product",product);

        return "product/create-product";
    }

    @PostMapping("/create-product")
    public String saveProduct(@ModelAttribute("product") Product product){

        productService.productCreate(product);


        return "redirect:/list";
    }
}
