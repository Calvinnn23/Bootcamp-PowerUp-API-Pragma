package com.pragma.bootcamp2024.adapters.driving.http.controller;

import com.pragma.bootcamp2024.adapters.driving.http.dto.request.AddCapacityRequest;
import com.pragma.bootcamp2024.adapters.driving.http.dto.request.UpdateCapacityRequest;
import com.pragma.bootcamp2024.adapters.driving.http.dto.response.CapacityResponse;
import com.pragma.bootcamp2024.adapters.driving.http.mapper.ICapacityRequestMapper;
import com.pragma.bootcamp2024.adapters.driving.http.mapper.ICapacityResponseMapper;
import com.pragma.bootcamp2024.domain.api.ICapacityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bootcamp")
@RequiredArgsConstructor
public class CapacityRestControllerAdapter {
    private final ICapacityRequestMapper iCapacityRequestMapper;
    private final ICapacityResponseMapper iCapacityResponseMapper;
    private final ICapacityServicePort iCapacityServicePort;

    @PostMapping("/capacity")
    public ResponseEntity<Void> saveCapacity(@RequestBody @Valid AddCapacityRequest capacityRequest) {
        iCapacityServicePort.saveCapacity(iCapacityRequestMapper.addRequestToCapacity(capacityRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/capacity/{capacityName}")
    public ResponseEntity<CapacityResponse> getCapacity(@PathVariable String capacityName) {
        return ResponseEntity.ok(iCapacityResponseMapper.toCapacityResponse(iCapacityServicePort.getCapacity(capacityName)));
    }

    @GetMapping("/capacity")
    public ResponseEntity<List<CapacityResponse>> getAllCapacities(Integer page, Integer size) {
        return ResponseEntity.ok(iCapacityResponseMapper.toCapacityResponseList(iCapacityServicePort.getAllCapacities(page, size)));
    }

    @GetMapping("/capacity/{technologyName}")
    public ResponseEntity<List<CapacityResponse>> getAllCapacitiesByTechnology(@RequestParam Integer page, @RequestParam Integer size, @PathVariable String technologyName) {
        return ResponseEntity.ok(iCapacityResponseMapper.toCapacityResponseList(iCapacityServicePort.getAllCapacitiesByTechnology(technologyName, page, size)));
    }

    @PutMapping("/capacity")
    public ResponseEntity<CapacityResponse> updateCapacity(@RequestBody @Valid UpdateCapacityRequest capacityRequest) {
        return ResponseEntity.ok(iCapacityResponseMapper.toCapacityResponse(iCapacityServicePort.updateCapacity(iCapacityRequestMapper.updateRequestToCapacity(capacityRequest))));
    }

    @DeleteMapping("/capacity/{id}")
    public ResponseEntity<Void> deleteCapacity(@PathVariable @Valid Long id) {
        iCapacityServicePort.deleteCapacity(id);
        return ResponseEntity.noContent().build();
    }
}
