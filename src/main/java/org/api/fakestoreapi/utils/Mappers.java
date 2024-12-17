package org.api.fakestoreapi.utils;

import org.api.fakestoreapi.dto.FSA_RequestProductDTO;
import org.api.fakestoreapi.exception.ThirdPartyAPIException;
import org.api.fakestoreapi.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yogeshjoga
 * The Mappers class provides utility methods to convert between Product and FSA_RequestProductDTO objects.
 * This class encapsulates the logic for mapping properties between these two entities.
 */
@Component
public class Mappers {

    /**
     * Converts a Product entity to an FSA_RequestProductDTO data transfer object by mapping relevant fields.
     *
     * @param product the Product entity to be converted; must not be null
     * @return an FSA_RequestProductDTO object containing the mapped data from the given Product entity
     */

    public FSA_RequestProductDTO productToFSADTO(Product product){
        FSA_RequestProductDTO dto = new FSA_RequestProductDTO();
        dto.setId(product.getId());
        dto.setTitle(product.getName());
   //     dto.setCategory(product.getProductCategory());
        dto.setDescription(product.getProductDescription());
        dto.setPrice(product.getProductPrice());
        return dto;
    }

    /**
     * Converts an FSA_RequestProductDTO object to a Product instance by mapping relevant fields.
     *
     * @param dto the FSA_RequestProductDTO object to be converted; must not be null
     * @return a Product instance populated with data from the provided FSA_RequestProductDTO object
     */

    public Product FSADTOToProduct(FSA_RequestProductDTO dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getTitle());
    //    product.setProductCategory(dto.getCategory());
        product.setProductDescription(dto.getDescription());
        product.setProductPrice(dto.getPrice());
        return product;
    }

    /**
     * Converts a list of FSA_RequestProductDTO objects to a list of Product instances by mapping relevant fields.
     *
     * @param dto the list of FSA_RequestProductDTO objects to be converted; must not be null
     * @return a list of Product instances populated with data from the provided list of FSA_RequestProductDTO objects
     */
    public List<Product>  FSADTOToProductGetAll(List<FSA_RequestProductDTO> dto){
        List<Product> products = new ArrayList<>();
        for(FSA_RequestProductDTO productDTO : dto){
            products.add(FSADTOToProduct(productDTO));
        }
        return products;
    }

}
