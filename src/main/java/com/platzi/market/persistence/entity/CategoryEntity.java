package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.util.List;


/**
 * @Entity Allow to this Class map the table category
 */
@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer idCategory;

    private String description;
    private Boolean active;

    /*
     * Shows a list of products associated with a category
     */
    @OneToMany(mappedBy = "category")
    private List<ProductEntity> productEntities;

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
