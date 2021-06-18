package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_products")
    private Integer idProduct;

    private String name;

    @Column(name = "id_category")
    private Integer idCategory;

    private String code;
    private Double price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_category", insertable = false, updatable = false) //Is for not insert or update a Category is only for get one
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "product")
    private List<ProductsShoppingEntity> productsShoppingsEntity;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
