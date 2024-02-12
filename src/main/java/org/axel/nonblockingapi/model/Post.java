package org.axel.nonblockingapi.model;

import lombok.*;

/**
 * Post class to store posts for the user
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Post
{
    private int userId;
    private int id;
    private String title;
    private String body;
}
