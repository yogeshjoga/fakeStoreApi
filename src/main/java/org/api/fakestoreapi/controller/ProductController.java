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
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    MultiValueMap<String, String> headers;


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


    /**
     * Retrieves a list of all products from the product service.
     *
     * This method interacts with the product service to fetch all available products
     * and returns them as a ResponseEntity containing a list of Product objects. If no
     * products are found, a ThirdPartyAPIException is thrown.
     *
     * @return A ResponseEntity containing a list of Product objects wrapped with appropriate
     *         headers and an HTTP status of OK if products are successfully retrieved.
     *         Throws ThirdPartyAPIException if no products are found.
     * @throws ThirdPartyAPIException If there is an error while fetching products from the service
     *                                or if no products are found.
     */
    @GetMapping("/all_products")
    public ResponseEntity<List<Product>> getAllProducts() throws ThirdPartyAPIException {
        headers = new LinkedMultiValueMap<>();
       List<Product> products = productService.getAllProducts();
       headers.add("Date", LocalDateTime.now().toString());
       if(products == null){
           throw  new ThirdPartyAPIException("No Products Found");
       }
       return new ResponseEntity<>(products,headers, HttpStatus.OK);
    }

    /**
     * Handles the creation of a new product.
     *
     * This method receives a product DTO, processes it using the product service,
     * and returns the created product information wrapped in a ResponseEntity with an HTTP status of OK.
     *
     * @param dto The FSA_RequestProductDTO object containing the product details to be created.
     * @return A ResponseEntity containing the created FSA_RequestProductDTO object and an HTTP status of OK.
     * @throws ThirdPartyAPIException If there is an error while interacting with the third-party API.
     */
    @PostMapping("/create_product")
    public ResponseEntity<FSA_RequestProductDTO> postProduct(@RequestBody FSA_RequestProductDTO dto) throws ThirdPartyAPIException {
        FSA_RequestProductDTO response = productService.postProduct(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
        // minor bug is there try to find our and fix it later @author yogesh joga
    }

    /**
     * Retrieves a list of products limited to the specified number.
     *
     * @param limit the maximum number of products to return
     * @return a ResponseEntity containing the list of products and an HTTP status of OK
     */
    @GetMapping("/products_by_limit")
    public ResponseEntity<List<Product>> getProductsByLimit(@RequestParam("limit") Long limit){
        List<Product> products = productService.getProductsByLimit(limit);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products_by_limit_and_offset")
    public ResponseEntity<List<Product>> getProductsByLimitAndOffset(@RequestParam("limit") Long limit,@RequestParam("offset") Long offset){
        List<Product> products = productService.getProductsByLimitAndOffset(limit);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
