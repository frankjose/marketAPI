package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "clients")
public class ClientEntity {

    @Id
    @Column(name = "id_clients")
    private  Integer idClients;

    @Column(name = "first_name")
    private String  firstName;

    @Column(name = "last_name")
    private String lastName;

    private String mobile;
    private String addres;
    private String email;

    @OneToMany(mappedBy = "client")
    private List<ShoppingEntity> shoppingEntities;

    public Integer getIdClients() {
        return idClients;
    }

    public void setIdClients(Integer idClients) {
        this.idClients = idClients;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ShoppingEntity> getShoppings() {
        return shoppingEntities;
    }

    public void setShoppings(List<ShoppingEntity> shoppingEntities) {
        this.shoppingEntities = shoppingEntities;
    }
}
