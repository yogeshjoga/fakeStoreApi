package org.api.fakestoreapi.service;


import org.api.fakestoreapi.exception.ThirdPartyAPIException;
import org.api.fakestoreapi.model.Product;

public interface IProductService {
    public Product getProductById(Long id) throws ThirdPartyAPIException;
}
