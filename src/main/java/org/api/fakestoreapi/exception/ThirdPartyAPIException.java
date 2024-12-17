package org.api.fakestoreapi.exception;


/**
 * Exception class representing an error encountered while interacting with a third-party API.
 *
 * This exception is typically thrown when a failure occurs during communication,
 * data retrieval, or processing of responses from an external, third-party API.
 *
 * It can be used to encapsulate and propagate errors related to third-party integrations
 * in a standardized way.
 */
public class ThirdPartyAPIException extends  Exception{
    public ThirdPartyAPIException(String message) {
        super(message);
    }
}
