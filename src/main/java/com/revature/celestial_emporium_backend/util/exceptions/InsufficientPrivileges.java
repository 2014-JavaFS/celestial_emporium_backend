package com.revature.celestial_emporium_backend.util.exceptions;

public class InsufficientPrivileges extends RuntimeException {
    public InsufficientPrivileges(String message){
        super(message);
    }
}
