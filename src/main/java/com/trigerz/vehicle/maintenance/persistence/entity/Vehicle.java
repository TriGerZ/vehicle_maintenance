package com.trigerz.vehicle.maintenance.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "VEHICLE")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "BRAND", length = 50)
    private String brand;

    @Size(max = 50)
    @NotNull
    @Column(name = "MODEL", nullable = false, length = 50)
    private String model;

    @Column(name = "PURCHASE_DATE")
    private LocalDate purchaseDate;

    @Column(name = "CURRENT_MILEAGE")
    private Integer currentMileage;

    @Column(name = "LAST_MILEAGE_UPDATE")
    private LocalDate lastMileageUpdate;

    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @OneToMany(mappedBy = "vehicle")
    private Set<Accessory> accessories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "vehicle")
    private Set<Operation> operations = new LinkedHashSet<>();

}