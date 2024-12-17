package org.api.fakestoreapi.service;


import org.api.fakestoreapi.exception.ThirdPartyAPIException;
import org.api.fakestoreapi.model.Product;

import java.util.List;

/**
 * Defines the contract for product-related operations.
 *
 * This interface declares methods for interacting with and retrieving product
 * data, potentially relying on third-party APIs or other external sources. The
 * implementing class is responsible for handling the specifics of data retrieval
 * and mapping to the internal data model.
 */
public interface IProductService {
    public Product getProductById(Long id) throws ThirdPartyAPIException;
    public List<Product> getAllProducts() throws ThirdPartyAPIException;
}
