package com.dauphine.blogger.exceptions;

public class CategoryNameAlreadyExists extends Exception{
    public CategoryNameAlreadyExists(String name) {
        super("The category: " + name + " already exists");
    }
}
