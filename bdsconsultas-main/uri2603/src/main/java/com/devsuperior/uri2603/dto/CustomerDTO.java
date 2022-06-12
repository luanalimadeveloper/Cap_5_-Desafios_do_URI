package com.devsuperior.uri2603.dto;

import com.devsuperior.uri2603.projections.CustomerMinProjection;

public class CustomerDTO {

    private String name;
    private String street;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String street) {
        this.name = name;
        this.street = street;
    }

    public CustomerDTO(CustomerMinProjection obj) {
        name = obj.getName();
        street = obj.getStreet();
    }

    @Override
    public String toString() {
        return "CustomerDTO {" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
