package com.nicaciopereira.workshopmongo.services.exeption;

public class ObjectNotFoundExeption  extends RuntimeException{
    private static final long serialVersionUID = 1l;

    public ObjectNotFoundExeption(String msg){
        super(msg);
    }
}

