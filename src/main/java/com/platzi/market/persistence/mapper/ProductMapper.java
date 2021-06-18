package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Mapping the Product Entity and Domain
 * In this case @Mapper incorporate a additional param ´use = {CategoryMapper.class}´ is the reference to the CategoryMapper interface
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    /**
     * Mapping from Entity to Domain
     * @param productEntity The Product Entity
     * @return The Product Domain
     */
    @Mappings({
            @Mapping(source = "productId", target = "idProduct"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "idCategory"),
            @Mapping(source = "stock", target = "stockQuantity"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "category", target = "category"),
    })
    Product toProduct(ProductEntity productEntity);
    List<Product> toProducts(List<ProductEntity> productEntities);

    @InheritInverseConfiguration
    ProductEntity toEntityProduct(Product product);
}

    /*
    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private Category category;
    */