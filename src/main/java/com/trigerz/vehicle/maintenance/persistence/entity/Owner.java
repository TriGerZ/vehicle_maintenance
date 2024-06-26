package com.trigerz.vehicle.maintenance.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "OWNER")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @Lob
    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "owner")
    private Set<Vehicle> vehicles = new LinkedHashSet<>();

}