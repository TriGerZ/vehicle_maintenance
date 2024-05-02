package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.rest.dto.OwnerDtoService;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.BasicOwnerReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.OwnerReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OwnerResDto;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(("/owners"))
@RestController
public class OwnerController {

    private final OwnerDtoService ownerDtoService;

    public OwnerController(OwnerDtoService ownerDtoService) {
        this.ownerDtoService = ownerDtoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OwnerResDto> getAllOwners() {
        return ownerDtoService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    public OwnerResDto getOwnerById(@PathVariable int id) {
        return ownerDtoService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOwner(@RequestBody BasicOwnerReqDto ownerDto) {
        ownerDtoService.save(ownerDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponse(responseCode = "409", content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    public void deleteOwnerById(@PathVariable int id) {
        ownerDtoService.delete(id);
    }
}
