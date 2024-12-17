package org.api.fakestoreapi.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseModel {
    private Long id;
    private String name;
    private String type;
}
