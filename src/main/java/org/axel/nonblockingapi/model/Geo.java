package org.axel.nonblockingapi.model;


import lombok.*;
/**
 * Geo class to store geographic information
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Geo
{
    private String lat;
    private String lng;

}
