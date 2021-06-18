package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;

import com.platzi.market.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    /**
     * Mapping from Entity to Domain
     * @param categoryEntity This represent the Entity Category
     * @return Is the domain Category
     */
    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "active", target = "active"),
    })
    Category toCategory(CategoryEntity categoryEntity);

    /**
     * Mapping the inverse, from the Domain to Entity
     * @param category The Domain
     * @return The Entity
     */
    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryEntity toEntityCategory(Category category);

}
