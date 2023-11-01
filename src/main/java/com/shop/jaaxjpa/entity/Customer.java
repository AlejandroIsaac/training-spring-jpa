package com.shop.jaaxjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "customer",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email_address"
        )
)
public class Customer {
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1,
            initialValue = 30
    )
    @Id
    @GeneratedValue(
            generator = "customer_sequence",
            strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long idCustomer;

    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false,
            length = 100
    )
    private String email;

    //Incrustar una entidad
    @Embedded
    private Address address;

    //Relacion ManyToMany
    @ManyToMany(
            mappedBy = "customerList"
    )
    private List<Local> localList;
}
