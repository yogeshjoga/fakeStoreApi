package org.api.fakestoreapi.exception;


/**
 * Exception class representing an invalid ID scenario.
 *
 * This exception is thrown when a provided ID does not meet valid criteria,
 * such as being outside the allowed range.
 *
 * Example usage scenario:
 * - When the ID is less than 1 or greater than the allowed maximum (e.g., 20).
 *
 * The exception can be handled globally or locally to manage user input errors
 * or enforce validation rules.
 */
public class IdNotValiedException extends  Exception{
    public IdNotValiedException(String message) {
        super(message);
    }
}
