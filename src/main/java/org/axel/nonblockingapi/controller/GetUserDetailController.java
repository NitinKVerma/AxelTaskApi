package org.axel.nonblockingapi.controller;

import org.axel.nonblockingapi.errors.exception.*;
import org.axel.nonblockingapi.model.*;
import org.axel.nonblockingapi.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

import java.io.*;

/**
 * GetUserDetailController that is used to fetch User Details
 */
@RestController
@RequestMapping("/api")
public class GetUserDetailController {

    @Autowired
    private GetUserDetailsService getUserDetailsService;

    /**
     *
     * @param userId
     * @return userdetails if found else UserNotFoundException
     */
    @GetMapping("/getUserDetails/{id}")
    public Mono<ResponseEntity<UserDetails>> getUserDetails(@PathVariable Integer id){
        return getUserDetailsService.getUserDetails(id)
                .map(body-> ResponseEntity.ok().body(body))
                .switchIfEmpty(Mono.error(UserNotFoundException::new));
    }
}


