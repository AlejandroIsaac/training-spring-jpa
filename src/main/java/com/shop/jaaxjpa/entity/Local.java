package com.shop.jaaxjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "manager")
public class Local {

    @Id
    @SequenceGenerator(
            name="local_sequence",
            sequenceName = "local_sequence",
            allocationSize = 1,
            initialValue = 100
    )
    @GeneratedValue(
            generator = "local_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long idLocal;

    private String name;
    private String floor;


    //relacion inidirecional OnetoOne
    @OneToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "id_manager", //nombre de la columna
            referencedColumnName = "idManager"//nombre de la columna a la que hace referencia la FK
    )
    private Manager manager;

    //Relacion ManyToMany
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "local_customer_map",
            joinColumns = @JoinColumn(name = "id_local", referencedColumnName = "idLocal"),
            inverseJoinColumns = @JoinColumn(name = "id_customer", referencedColumnName = "id")
    )
    private List<Customer> customerList;








    //Relacion OneToMany
    /*@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(//configuracion la tomara la tabla order
            name = "id_Local",
            referencedColumnName = "idLocal"
    )
    List<Order> orderList;*/

}
