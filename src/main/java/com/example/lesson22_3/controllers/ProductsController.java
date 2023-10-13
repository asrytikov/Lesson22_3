package com.example.lesson22_3.controllers;

import com.example.lesson22_3.model.Product;
import com.example.lesson22_3.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model){
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.addProduct(product);

        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

  /*  @PostMapping("/products")
    public String addProduct2(Product product, Model model){
        productService.addProduct(product);
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }*/

}
