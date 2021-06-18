package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.ProductEntity;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Repository: Allow that this class can do queries to the databases class other option is use @Component that is a general
 */
@Repository
public class ProductoRepository implements ProductRepository   {

    private ProductCrudRepository productCrudRepository;
    private ProductMapper mapper;
    /**
     * Get all products list
     * @return List<Product>
     */
    @Override
    public List<Product> getAll(){
        //The interface ProductCrudRepository allow get all products from de Data Base
        //retrieve a productEntity
        List<ProductEntity> productEntity = (List<ProductEntity>) productCrudRepository.findAll();
        //Mapping the productEntity to Product domain
        return mapper.toProducts(productEntity);
    }

    /**
     * Retrieve a list of products from a specific category
     * @param idCategory The id of a category
     * @return List<Product>
     */
    @Override
    public List<Product> getByCategory(int idCategory){
        //Retrieve the productsEntity throw to the ProductCrudRepository interface
        List<ProductEntity> productsEntity =  productCrudRepository.findByIdCategoryOderByNameAcs(idCategory);
        //Mapping the productsEntity to Products domain
        return mapper.toProducts(productsEntity);
    }

    /**
     *  Retrieve a product by Id
     * @param idProduct The product Id
     * @return Optional<Product>
     */
    @Override
    public Optional<Product> getProduct(int idProduct){
        Optional<ProductEntity> productEntity = productCrudRepository.findById(idProduct);
        //The map function allows you to go through each of the products in the Optional<> and pass them through the mapper.toProduct
        return productEntity.map(product -> mapper.toProduct(product));

    }


    /**
     * Save a product into the database
     * @param product The product object
     * @return Product
     */
    @Override
    public Product save(Product product){
        ProductEntity productEntity = mapper.toEntityProduct(product);
        ProductEntity produc = productCrudRepository.save(productEntity);

        return mapper.toProduct(produc);
    }

    /**
     * Delete a specific product
     * @param idProduct The productId
     */
    public void delete(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }

    /**
     * Retrieve the products with less quantity in stock
     * @param stockQuantity
     * @param active
     * @return
     */
    @Override
    public Optional<List<Product>> getLessStockProduct(int stockQuantity, boolean active){

        Optional<List<ProductEntity>> productEntity = productCrudRepository.findByStockQuantityLessThanAndActive(stockQuantity,active);
        return productEntity.map(products -> mapper.toProducts(products));
    }


}
