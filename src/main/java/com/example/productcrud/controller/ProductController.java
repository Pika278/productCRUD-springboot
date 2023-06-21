package com.example.productcrud.controller;

import com.example.productcrud.model.ProductModel;
import com.example.productcrud.service.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
public class ProductController {

    private ProductImpl productImpl;

    @Autowired
    public ProductController(ProductImpl productImpl) {
        this.productImpl = productImpl;
    }
    @GetMapping("/test")
    private String test() {
        return "sucsess";
    }

    @PostMapping("/")
    public void addProduct(@RequestBody ProductModel productModel) {
        productImpl.addProduct(productModel);
    }

    @DeleteMapping("{productID}")
    public void deleteProduct(@PathVariable("productID") long productId) {
        productImpl.deleteProduct(productId);
    }

    @GetMapping("/list")
    private List<ProductModel> getAllProduct() {
        return productImpl.getAllProduct();
    }
}
