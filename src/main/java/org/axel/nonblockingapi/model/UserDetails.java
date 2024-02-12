package org.axel.nonblockingapi.model;

import lombok.*;

import java.util.*;

/**
 * UserDetails to store combined information for the user and posts for the specific userId
 */
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor(staticName = "create")
@Builder
public class UserDetails {

    private User user;
    private List<Post> posts;
}
