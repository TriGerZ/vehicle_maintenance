package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.rest.dto.OwnerDtoService;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.OwnerReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OwnerResDto;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerControllerImpl implements OwnerController {

    private final OwnerDtoService ownerDtoServiceImpl;

    public OwnerControllerImpl(OwnerDtoService ownerDtoServiceImpl) {
        this.ownerDtoServiceImpl = ownerDtoServiceImpl;
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OwnerResDto> getAll() {
        return ownerDtoServiceImpl.getAll();
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    public OwnerResDto getById(@PathVariable int id) {
        return ownerDtoServiceImpl.getById(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OwnerReqDto req) {
        ownerDtoServiceImpl.save(req);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponse(responseCode = "409", content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    public void deleteById(@PathVariable int id) {
        ownerDtoServiceImpl.delete(id);
    }
}
