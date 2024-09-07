package com.walmart.api.Walmart.API.controller;

import com.walmart.api.Walmart.API.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.walmart.api.Walmart.API.entity.Product;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{upc}")
    @CrossOrigin
    public ResponseEntity<Product> getProduct(@PathVariable String upc){
        Optional<Product> product = productService.getProduct(upc);

        if(product.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
    }

    //TODO
    /*@PatchMapping("/{upc}")
    public Product patchProduct(@PathVariable String upc, @RequestBody String requestBody){
    }*/

    @DeleteMapping("/{upc}")
    public ResponseEntity<Product> deleteProduct(@PathVariable String upc){
        try{
            productService.deleteProduct(upc);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NullPointerException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
