package org.api.fakestoreapi.controller;


import org.api.fakestoreapi.client.FakeStoreApiClient;
import org.api.fakestoreapi.dto.FSA_RequestProductDTO;
import org.api.fakestoreapi.exception.IdNotValiedException;
import org.api.fakestoreapi.exception.ThirdPartyAPIException;
import org.api.fakestoreapi.model.Product;
import org.api.fakestoreapi.service.IProductService;
import org.api.fakestoreapi.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author yogeshjoga
 *
 * Controller class responsible for handling product-related requests.
 * This class defines REST endpoints for managing and retrieving product data.
 */
@RestController
@RequestMapping("/api/v1/")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private FakeStoreApiClient client;

    @Autowired
    private Mappers mappers;

    MultiValueMap<String, LocalDateTime> headers;


    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id The unique identifier of the product to retrieve. Must be a positive integer between 1 and 20 (inclusive).
     * @return A ResponseEntity containing the product details wrapped in a Product object and appropriate headers with HTTP status OK.
     *         If the product is not found, returns a ResponseEntity with a null body and HTTP status NOT_FOUND.
     * @throws ThirdPartyAPIException If there is an error while fetching data from the third-party API.
     * @throws IdNotValiedException If the provided id is less than 1 or greater than 20.
     */

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id)throws ThirdPartyAPIException,IdNotValiedException {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        try{
            if(id < 1){
                throw new IdNotValiedException("Your Id is below 1, there is no Id below 1 Right please Re_Check into your Id and correct it!");
            }else if(id > 20){
                throw new IdNotValiedException("Your Id is much more higher then our DB Range! ");
            }
            Product product = productService.getProductById(id);
            if(product != null){
                headers.add("Date", LocalDateTime.now().toString());
                return new ResponseEntity<>(product, headers, HttpStatus.OK);
            }
        }catch(IdNotValiedException exception){
            throw exception;
        }
        return null;
    }


}
