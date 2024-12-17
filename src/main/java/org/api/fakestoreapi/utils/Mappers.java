package org.api.fakestoreapi.utils;

import org.api.fakestoreapi.dto.FSA_RequestProductDTO;
import org.api.fakestoreapi.exception.ThirdPartyAPIException;
import org.api.fakestoreapi.model.Product;
import org.springframework.stereotype.Component;

@Component
public class Mappers {

    public FSA_RequestProductDTO productToFSADTO(Product product){
        FSA_RequestProductDTO dto = new FSA_RequestProductDTO();
        dto.setId(product.getId());
        dto.setTitle(product.getName());
   //     dto.setCategory(product.getProductCategory());
        dto.setDescription(product.getProductDescription());
        dto.setPrice(product.getProductPrice());
        return dto;
    }


    public Product FSADTOToProduct(FSA_RequestProductDTO dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getTitle());
    //    product.setProductCategory(dto.getCategory());
        product.setProductDescription(dto.getDescription());
        product.setProductPrice(dto.getPrice());
        return product;
    }

}
