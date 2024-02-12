package org.axel.nonblockingapi.model;


import lombok.*;

/**
 * User class to store user information
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User
{
    private int id;
    private String name;
    private String userName;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

}
