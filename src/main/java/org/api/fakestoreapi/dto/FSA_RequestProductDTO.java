package org.api.fakestoreapi.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class for requesting product details.
 * This class is used to encapsulate data for communication between layers,
 * particularly for creating or updating product information.
 *
 * Fields:
 * - id: Unique identifier of the product.
 * - title: The title or name of the product.
 * - description: A short description of the product.
 * - price: The price of the product.
 * - image: URL or path to the image of the product.
 */

@Setter
@Getter
public class FSA_RequestProductDTO {
    private Long id;
    private String title;
 //   private String category;
    private String description;
    private Double price;
    private String image;
//    private Double rating;
  //  private Integer count;
}
