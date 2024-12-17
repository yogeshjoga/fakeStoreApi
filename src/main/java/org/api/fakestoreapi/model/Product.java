package org.api.fakestoreapi.model;


import lombok.Getter;
import lombok.Setter;

/**
 * Represents a product in the system.
 *
 * The Product class extends BaseModel, inheriting common attributes such as
 * id, name, and type. This class is specific to product-related information,
 * including fields for the product owner, description, price, and category.
 *
 * It provides a foundation for managing and organizing product data.
 */
@Setter
@Getter
public class Product extends BaseModel{
    private String productOwner;
    private String productDescription;
    private Double productPrice;
    private String productCategory;
}
/**
 * here no need to connect Database
 * here we will get information through 3rd party API's so no need to make tables
 */