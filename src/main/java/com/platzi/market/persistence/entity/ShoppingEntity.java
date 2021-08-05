package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shopping")
public class ShoppingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shopping")
    private Integer idShopping;

    private LocalDateTime date;

    @Column(name = "payment_way")
    private String paymentWay;

    private String comment;
    private Boolean active;

    @Column(name = "id_clients")
    private Integer idClients;

    @ManyToOne
    @JoinColumn(name = "id_clients", updatable = false, insertable = false)
    private ClientEntity clientEntity;

    @OneToMany(mappedBy = "productEntity")
    private List<ProductsShoppingEntity> products;

    public Integer getIdShopping() {
        return idShopping;
    }

    public void setIdShopping(Integer idShopping) {
        this.idShopping = idShopping;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getIdClients() {
        return idClients;
    }

    public void setIdClients(Integer idClients) {
        this.idClients = idClients;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public List<ProductsShoppingEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsShoppingEntity> products) {
        this.products = products;
    }
}
