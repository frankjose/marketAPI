package com.platzi.market.domain.service;


import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int idProduct){
        return productRepository.getProduct(idProduct);
    }

    public Optional<List<Product>> getByCategory(int idCategory){
        return productRepository.getByCategory(idCategory);
    }

    public Product save(Product product){
        return  productRepository.save(product);
    }

    public boolean delete(int idProduct){

        return productRepository.getProduct(idProduct).map(product -> {
            productRepository.delete(idProduct);
            return true;
        }).orElse(false);
    }

    public Optional<List<Product>> getLessStockProduct(int stockQuantity, boolean active){
        return productRepository.getLessStockProduct(stockQuantity, active);
    }

}
