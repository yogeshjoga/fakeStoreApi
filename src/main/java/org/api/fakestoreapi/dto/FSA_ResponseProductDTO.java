package org.api.fakestoreapi.dto;


import lombok.Getter;
import lombok.Setter;


/**
 * Data Transfer Object (DTO) class for responding with product details.
 * This class is used to encapsulate and transfer data across
 * different layers or components in the application, particularly
 * for handling the response related to product information.
 *
 * Fields:
 * - id: Unique identifier of the product.
 * - name: Name of the product.
 * - type: Type or category classification of the product.
 * - owner: The owner or entity responsible for the product.
 * - description: Detailed description of the product.
 * - price: Price of the product.
 * - category: Specific product category or group.
 */
@Setter
@Getter
public class FSA_ResponseProductDTO {
    private Long id;
    private String name;
    private String type;
    private String owner;
    private String description;
    private Double price;
    private String category;
}