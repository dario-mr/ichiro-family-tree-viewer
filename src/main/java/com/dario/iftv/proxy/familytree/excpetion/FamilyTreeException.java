package com.dario.iftv.proxy.familytree.excpetion;

public class FamilyTreeException extends RuntimeException {

    public FamilyTreeException(String message, Exception ex) {
        super(message, ex);
    }

}
