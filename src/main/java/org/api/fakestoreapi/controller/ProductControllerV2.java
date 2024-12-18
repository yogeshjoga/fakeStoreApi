package org.api.fakestoreapi.controller;


import org.api.fakestoreapi.client.FakeStoreApiClient;
import org.api.fakestoreapi.dto.FSA_RequestProductDTO;
import org.api.fakestoreapi.service.IProductService;
import org.api.fakestoreapi.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v2/")
public class ProductControllerV2 {

    @Autowired
    private IProductService productService;

    @Autowired
    private FakeStoreApiClient client;

    @Autowired
    private Mappers mappers;

    MultiValueMap<String, String> headers;



    /**
     * Handles the creation of a new product by accepting product details in the request body
     * and returning the created product details in the response.
     *
     * @param dto the product details provided by the user in the request body
     * @return a ResponseEntity containing the created product details and HTTP status
     */
    @PostMapping("/create_new_product")
    public ResponseEntity<FSA_RequestProductDTO> createNewProduct(@RequestBody FSA_RequestProductDTO dto){
        headers = new LinkedMultiValueMap<>();
        headers.add("Date", LocalDateTime.now().toString());
        headers.add("Api_Version", "2.0");
        FSA_RequestProductDTO response = productService.createNewProduct(dto);
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
        // minor bug is there try to find our and fix it later @author yogesh joga
    }
}
