package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * This interface extend from CrudRepository<T, ID> Where T = The class that represents the DB table, ID = The primary key
 *
 * @author fjose
 */
public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    //Adding custom queries

    /**
     * Return the category in Acs order
     * @param idCategory
     * @return List<Product>
     */
    List<ProductEntity> findByIdCategoryOderByNameAcs(int idCategory);

    /**
     * Retrieve the products with less stock
     * @param stockQuantity The reference stockQuantity
     * @param active Is active
     * @return Optional<List<Product>>
     */
    Optional<List<ProductEntity>> findByStockQuantityLessThanAndActive(int stockQuantity, Boolean active );


}
