package com.example.county.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "county_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountyDetails {
    @Id
    @Column(name = "fips")
    private String fips;

    @Column(name = "state")
    private String state;

    @Column(name = "name")
    private String name;

}