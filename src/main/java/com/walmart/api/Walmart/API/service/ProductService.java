package com.walmart.api.Walmart.API.service;

import com.walmart.api.Walmart.API.entity.Product;
import com.walmart.api.Walmart.API.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private static final Logger logger = LogManager.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // For now, I am choosing to return Optionals in service getters, as it is the job of a service getter
    // to attempt to locate an entity in a database and return it, however, it is determined
    // to be common that users will attempt to load product data that doesn't exist
    // by URL manipulation of an invalid UPC.
    public Optional<Product> getProduct(String upc){
        Optional<Product> product = productRepository.findByUpc(upc);

        return product;
    }

    // If Product with UPC exists, delete it.
    // I am delegating the responsibility of logging failures to this method, as it is the job of a controller to
    // orchestrate the deletion of an entity, but the sole purpose of this method to actually do it.
    public boolean deleteProduct(String upc){
        Optional<Product> product = productRepository.findByUpc(upc);

        if(product.isEmpty()){
            logger.info("Unable to locate Product with UPC `{}`.", upc);
            return false;
        }else{
            productRepository.delete(product.get());
            logger.info("Successfully located and deleted Product with UPC `{}`.", upc);
            return true;
        }
    }
}
