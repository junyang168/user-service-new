package com.broadcom.userservice;

import java.io.*;
import org.springframework.dao.*;

public class UserException extends Exception {
    private String message;

    public UserException(String message) {
        this.message = message;
     }

     public UserException(DataAccessException ex) {
        this.message = ex.getMessage();
     }

}