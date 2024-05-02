package com.trigerz.vehicle.maintenance.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public final class OwnerModel {
    private Integer id;
    private String name;
    private List<VehicleModel> vehicles;

}
