package org.axel.nonblockingapi.model;


import lombok.*;

/**
 * Address class to store address of user
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address
{
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}
