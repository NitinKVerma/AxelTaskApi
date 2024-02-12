package org.axel.nonblockingapi.client;

import org.axel.nonblockingapi.config.*;
import org.axel.nonblockingapi.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.*;

import java.util.*;

/**
 * PostClient that is used to get post for the specific userId
 */
@Service
public class PostClient {

    private final WebClient client;

    @Autowired
    private Utils util;

    /**
     *
     * @param builder
     * @param utils
     */
    public PostClient(WebClient.Builder builder, Utils utils) {
        this.util = utils;
        this.client = builder.baseUrl(util.getUrl()+"/posts").build();
    }

    /**
     *
     * @param id
     * @return post if found else emptyList
     */
    public Mono<List<Post>> getPosts(Integer id){
        return this.client
                .get()
                .uri(b -> b.queryParam("userId", id).build())
                .retrieve()
                .bodyToFlux(Post.class)
                .collectList()
                .onErrorReturn(Collections.emptyList()); // in case of error, switch it to empty list
    }

}
