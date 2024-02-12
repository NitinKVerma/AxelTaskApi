package org.axel.nonblockingapi.service;

import org.axel.nonblockingapi.model.*;
import org.springframework.stereotype.*;
import reactor.core.publisher.*;

@Repository
public interface GetUserDetailsService {
    /**
     *
     * @param id
     * @return Mono<UserDetails>
     */
    Mono<UserDetails> getUserDetails(Integer id);
}
