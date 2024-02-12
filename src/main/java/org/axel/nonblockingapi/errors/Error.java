package org.axel.nonblockingapi.errors;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.io.*;

/**
 * Error class
 */
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Error implements Serializable {

    USER_NOT_FOUND(1003, "User not found");

    private int code;
    private String message;

    Error(int code, String message) {
        this.code = code;
        this.message = message;
    }
}