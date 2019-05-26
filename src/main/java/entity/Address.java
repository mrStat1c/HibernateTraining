package entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(name="country")
    private String country;
    @Column(name="city")
    private String city;
    @Column(name="street")
    private String street;
    @Column(name="post_code", length = 10)
    private String postCode;

}
