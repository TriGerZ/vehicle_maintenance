package com.trigerz.vehicle.maintenance.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "HISTORY")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "DATE")
    private LocalDate date;

    @Lob
    @Column(name = "COMMENT")
    private String comment;

    @Lob
    @Column(name = "LINK")
    private String link;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "MILEAGE")
    private Integer mileage;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "OPERATION_ID")
    private Operation operation;

}