package com.walmart.api.Walmart.API.service;

import com.walmart.api.Walmart.API.entity.Product;
import com.walmart.api.Walmart.API.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProduct(String upc){
        return productRepository.findByUpc(upc);
    }

    public void deleteProduct(String upc){
        Optional<Product> product = productRepository.findByUpc(upc);

        if(product.isEmpty()){
            throw new NullPointerException("Product with UPC \"" + upc + "\" does not exist.");
        }else{
            productRepository.delete(product.get());
        }
    }
}
