package org.api.fakestoreapi.dto;


import lombok.Getter;
import lombok.Setter;

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
