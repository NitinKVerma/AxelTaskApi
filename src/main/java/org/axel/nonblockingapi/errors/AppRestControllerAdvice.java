package org.axel.nonblockingapi.errors;

import lombok.extern.log4j.*;
import org.axel.nonblockingapi.errors.exception.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import static org.axel.nonblockingapi.errors.Error.USER_NOT_FOUND;

/**
 * AppRestControllerAdvice for generic exception handling
 */
@Log4j2
@RestControllerAdvice
public class AppRestControllerAdvice {

    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Error wrongInputException(final UserNotFoundException e) {
        return USER_NOT_FOUND;
    }
}
