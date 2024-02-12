package org.axel.nonblockingapi.model;


import lombok.*;
/**
 * Company class to store company details of user
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Company
{
    private String name;
    private String catchPhrase;
    private String bs;

}
