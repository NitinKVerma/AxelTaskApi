package org.axel.nonblockingapi.client;

import org.axel.nonblockingapi.config.*;
import org.axel.nonblockingapi.model.*;
import org.springframework.stereotype.*;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.*;

/**
 *  UserClient is used to store user details
 */
@Service
public class UserClient {

    private final WebClient client;

    /**
     *
     * @param builder
     * @param config
     */
    public UserClient(WebClient.Builder builder, Utils config) {
        this.client = builder.baseUrl(config.url+"/users/").build();

    }

    /**
     *
     * @param id
     * @return user details else empty
     */
    public Mono<User> getUser(Integer id){
        return this.client
                .get()
                .uri("{id}", id)
                .retrieve()
                .bodyToMono(User.class)
                .onErrorResume(ex -> Mono.empty());
    }
}
