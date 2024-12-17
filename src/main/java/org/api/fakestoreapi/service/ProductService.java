package org.api.fakestoreapi.service;


import org.api.fakestoreapi.client.FakeStoreApiClient;
import org.api.fakestoreapi.dto.FSA_RequestProductDTO;
import org.api.fakestoreapi.exception.ThirdPartyAPIException;
import org.api.fakestoreapi.model.Product;
import org.api.fakestoreapi.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Service class that implements product-related operations by communicating with
 * a third-party API and using utility mappers for data conversion.
 *
 * This class provides functionality to retrieve product details and map the
 * data between the third-party API's response structure and the internal Product model.
 */

@Service
public class ProductService implements IProductService {

    @Autowired
    private Mappers mappers;

    @Autowired
    FakeStoreApiClient fakeStoreApiClient;


    /**
     * Retrieves a product by its unique identifier by communicating with a third-party API
     * and converting the response into a Product object.
     *
     * @param id The unique identifier of the product to retrieve; must not be null.
     * @return A Product object containing the details of the requested product.
     * @throws ThirdPartyAPIException If an error occurs while fetching the product details
     *         from the third-party API.
     */
    @Override
    public Product getProductById(Long id) throws ThirdPartyAPIException {
        FSA_RequestProductDTO dto = fakeStoreApiClient.getProductById(id);
        return mappers.FSADTOToProduct(dto);
    }


    /**
     * Retrieves a list of all products by communicating with a third-party API and
     * converting the response into a list of Product objects.
     *
     * @return A list of Product objects containing details of all available products.
     * @throws ThirdPartyAPIException If an error occurs while fetching the product data
     *         from the third-party API.
     */
    @Override
    public List<Product> getAllProducts() throws ThirdPartyAPIException {
        List<FSA_RequestProductDTO> dto = fakeStoreApiClient.getAllProducts();
        return mappers.FSADTOToProductGetAll(dto);
    }

    @Override
    public FSA_RequestProductDTO postProduct(FSA_RequestProductDTO dto) throws ThirdPartyAPIException {
         return fakeStoreApiClient.postProduct(dto);
    }


}
