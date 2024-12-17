package org.api.fakestoreapi.client;


import org.api.fakestoreapi.dto.FSA_RequestProductDTO;
import org.api.fakestoreapi.exception.ThirdPartyAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * A client class responsible for interacting with the Fake Store API.
 * Provides methods for retrieving product data and validating responses.
 *
 * This class uses RestTemplate to perform HTTP requests and handles
 * API responses for further processing. It also performs validation
 * of DTO responses to ensure compliance with the expected data model.
 */
@Component
public class FakeStoreApiClient {

    @Autowired
    RestTemplateBuilder builder;


    private <T> ResponseEntity<T> requestForEntity(String url,HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = builder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    private FSA_RequestProductDTO dtoValidator(ResponseEntity<FSA_RequestProductDTO> dto){
        if(dto.getStatusCode().is2xxSuccessful() && dto.getBody() != null){
            return dto.getBody();
        }
        return null;
    }

    //----------------------------------------------------------------------------------------------------------

    // Write functional code below here

    /**
     * Retrieves the product details by its unique identifier.
     *
     * @param id The unique identifier of the product to retrieve.
     * @return An instance of FSA_RequestProductDTO containing the product details.
     * @throws ThirdPartyAPIException If there is an error while interacting with the third-party API.
     */
    public FSA_RequestProductDTO getProductById(Long id) throws ThirdPartyAPIException {

        ResponseEntity<FSA_RequestProductDTO> responseEntity = requestForEntity("https://fakestoreapi.com/products/{id}",
                                                                    HttpMethod.GET, null, FSA_RequestProductDTO.class, id);
        if(responseEntity == null){
            throw new ThirdPartyAPIException("Your Business API not Working Please try Again Thank you!");
        }
        return dtoValidator(responseEntity);
    }


}
