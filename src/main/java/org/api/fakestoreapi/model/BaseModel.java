package org.api.fakestoreapi.model;


import lombok.Getter;
import lombok.Setter;


/**
 * Abstract base class to represent a foundational model in the system.
 *
 * The BaseModel class provides common attributes shared across different
 * models, including a unique identifier, a name, and a type. By extending
 * this class, subclasses inherit these attributes, allowing standardized
 * handling of fundamental properties across the application.
 */
@Setter
@Getter
public abstract class BaseModel {
    private Long id;
    private String name;
    private String type;
}
