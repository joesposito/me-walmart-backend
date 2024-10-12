package com.walmart.api.Walmart.API.controller;

import com.walmart.api.Walmart.API.service.ProductService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.walmart.api.Walmart.API.entity.Product;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final static Logger logger = LogManager.getLogger(ProductController.class);

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //TODO: Implementation of create service method.
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{upc}")
    public ResponseEntity<Product> getProduct(@PathVariable String upc){
        Optional<Product> optionalProduct = productService.getProduct(upc);

        if(optionalProduct.isEmpty()){
            logger.info("Failed GET request for Product with UPC `{}`.", upc);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            logger.info("Successful GET request for Product with UPC `{}`.", upc);
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        }
    }

    //TODO
    /*@PatchMapping("/{upc}")
    public Product patchProduct(@PathVariable String upc, @RequestBody String requestBody){
    }*/

    // Delete product by UPC
    @DeleteMapping("/{upc}")
    public ResponseEntity<Product> deleteProduct(@PathVariable String upc){
        if(productService.deleteProduct(upc)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            logger.error("Could not DELETE Product with UPC `{}`.", upc);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
