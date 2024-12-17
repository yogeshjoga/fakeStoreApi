package org.api.fakestoreapi.service;


import org.api.fakestoreapi.client.FakeStoreApiClient;
import org.api.fakestoreapi.dto.FSA_RequestProductDTO;
import org.api.fakestoreapi.exception.ThirdPartyAPIException;
import org.api.fakestoreapi.model.Product;
import org.api.fakestoreapi.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    private Mappers mappers;

    @Autowired
    FakeStoreApiClient fakeStoreApiClient;

    @Override
    public Product getProductById(Long id) throws ThirdPartyAPIException {
        FSA_RequestProductDTO dto = fakeStoreApiClient.getProductById(id);
        return mappers.FSADTOToProduct(dto);
    }


}
