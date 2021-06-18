package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;
import java.util.List;
import java.util.Optional;

/**
 * This interface tells the other repositories to use it how they should behave in terms of the Product object
 * This interface define the rules if other repositories want use or access to Product into database
 * This guarantees not to couple this solution to a specific database, because we must always speak in terms of the domain.
 */
public interface ProductRepository {

    /**
     * Get all products list
     * @return List<Product>
     */
    List<Product> getAll();

    /**
     * Retrieve a list of products from a specific category
     * @param idCategory The id of a category
     * @return List<Product>
     */
    List<Product> getByCategory(int idCategory);

    /**
     *  Retrieve a product by Id
     * @param idProduct The product Id
     * @return Optional<Product>
     */
    Optional<Product> getProduct(int idProduct);

    /**
     * Save a product into the database
     * @param product The product object
     * @return Product
     */
    Product save(Product product);

    /**
     * Delete a specific product
     * @param idProduct The productId
     */
    void delete(int idProduct);

    /**
     * Retrieve the products with less quantity in stock
     * @param stockQuantity
     * @param active
     * @return
     */
    Optional<List<Product>> getLessStockProduct(int stockQuantity, boolean active);

}
