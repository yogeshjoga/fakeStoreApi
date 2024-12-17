package org.api.fakestoreapi.dto;


import lombok.Getter;
import lombok.Setter;

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