package org.axel.nonblockingapi.controller;

import org.axel.nonblockingapi.errors.exception.*;
import org.axel.nonblockingapi.model.*;
import org.axel.nonblockingapi.service.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.reactive.*;
import org.springframework.boot.test.mock.mockito.*;

import static org.axel.nonblockingapi.errors.Error.USER_NOT_FOUND;
import org.springframework.test.context.junit.jupiter.*;
import org.springframework.test.web.reactive.server.*;
import reactor.core.publisher.*;

import java.util.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(GetUserDetailController.class)
public class GetUserDetailsControllerTest {

    @MockBean
    private GetUserDetailsService service;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
    }

    /**
     * shouldGetUserDetailsFail to handle if user not found
     */
    @Test
    void shouldGetUserDetailsFail() {

        when(service.getUserDetails(100)).thenThrow(new UserNotFoundException());

        webTestClient
                .get().uri("/api/getUserDetails/{id}",100)
                .exchange()
                .expectStatus()
                .isForbidden()
                .expectBody()
                .jsonPath("code").isEqualTo(USER_NOT_FOUND.getCode());

    }

    /**
     * shouldGetUserDetails return user details
     */
    @Test
    void shouldGetUserDetails() {
        Address address = Address.builder().build();
        Company company  = Company.builder().build();

        User user = User.builder()
                .id(1)
                .name("TestName")
                .userName("UserName")
                .email("test@email.com")
                .phone("011-098-9999")
                .website("sample.com")
                .address(address)
                .company(company)
                .build();

        Post post = Post.builder().build();
        List<Post> listPost= new ArrayList<>();
        listPost.add(post);

        UserDetails userDetails = UserDetails.builder().user(user).posts(listPost).build();

        Mockito
                .when(service.getUserDetails(1))
                .thenReturn(Mono.just(userDetails));

        webTestClient
                .get().uri("/api/getUserDetails/{id}",1)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(UserDetails.class);
    }
}
