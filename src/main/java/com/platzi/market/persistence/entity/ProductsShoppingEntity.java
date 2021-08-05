package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products_shopping")
public class ProductsShoppingEntity {

    @EmbeddedId
    private ProductsShoppingPK id;
    private Integer quantity;
    private BigDecimal total;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "id_products", updatable = false, insertable = false)
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "id_shopping", updatable = false, insertable = false)
    private ShoppingEntity shoppingEntity;

    public ProductsShoppingPK getId() {
        return id;
    }

    public void setId(ProductsShoppingPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public ShoppingEntity getShoppingEntity() {
        return shoppingEntity;
    }

    public void setShoppingEntity(ShoppingEntity shoppingEntity) {
        this.shoppingEntity = shoppingEntity;
    }
}
