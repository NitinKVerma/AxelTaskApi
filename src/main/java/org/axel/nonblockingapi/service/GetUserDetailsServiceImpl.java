package org.axel.nonblockingapi.service;

import org.axel.nonblockingapi.client.*;
import org.axel.nonblockingapi.model.*;
import org.springframework.stereotype.*;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.*;
import reactor.util.function.*;

import java.util.*;

@Service
public class GetUserDetailsServiceImpl implements GetUserDetailsService {

    private final UserClient userClient;
    private final PostClient postClient;

    /**
     *
     * @param userClient
     * @param postClient
     */
    public GetUserDetailsServiceImpl(UserClient userClient, PostClient postClient) {
        this.userClient = userClient;
        this.postClient = postClient;
    }

    /**
     *
     * @param id
     * @return User + Posts in zip
     * @throws WebClientResponseException
     */
    @Override
    public Mono<UserDetails> getUserDetails(Integer id) throws WebClientResponseException {
        return Mono.zip(
                        this.userClient.getUser(id),
                        this.postClient.getPosts(id)
                )
                .map(this::combine);
    }

    /**
     *
     * @param tuple
     * @return User Details
     */
    private UserDetails combine(Tuple2<User, List<Post>> tuple){
        return UserDetails.create(
                tuple.getT1(),
                tuple.getT2()
        );
    }
}
