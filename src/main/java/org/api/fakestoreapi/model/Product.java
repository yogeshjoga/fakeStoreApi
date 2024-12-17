package org.api.fakestoreapi.model;


import lombok.Getter;
import lombok.Setter;

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