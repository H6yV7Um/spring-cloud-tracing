package com.igitras.demo.gateway.web;

import java.io.Serializable;

/**
 * Created by mason on 8/12/16.
 */
public class Person implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }
}
