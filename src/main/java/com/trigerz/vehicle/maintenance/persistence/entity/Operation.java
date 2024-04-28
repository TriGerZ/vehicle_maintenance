package com.trigerz.vehicle.maintenance.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "OPERATION")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "TYPE", nullable = false, length = 50)
    private String type;

    @Column(name = "PERIODICITY_MILEAGE")
    private Integer periodicityMileage;

    @Column(name = "PERIODICITY_MONTH")
    private Integer periodicityMonth;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "operation")
    private Set<History> histories = new LinkedHashSet<>();

}