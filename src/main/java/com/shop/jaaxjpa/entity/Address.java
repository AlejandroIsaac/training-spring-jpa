package com.shop.jaaxjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "city", column =@Column(name = "customer_city")),
        @AttributeOverride(name = "mainStreet", column =@Column(name = "customer_mainStreet")),
        @AttributeOverride(name = "secondStreet", column =@Column(name = "secondStreet") )
        })

public class Address {
    private String city;
    private String mainStreet;
    private String secondStreet;
}
