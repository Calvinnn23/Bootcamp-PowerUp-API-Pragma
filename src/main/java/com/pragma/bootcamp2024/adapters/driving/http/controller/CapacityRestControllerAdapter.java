package com.pragma.bootcamp2024.adapters.driving.http.controller;

import com.pragma.bootcamp2024.adapters.driving.http.dto.request.AddCapacityRequest;
import com.pragma.bootcamp2024.adapters.driving.http.dto.response.CapacityResponse;
import com.pragma.bootcamp2024.adapters.driving.http.mapper.ICapacityRequestMapper;
import com.pragma.bootcamp2024.adapters.driving.http.mapper.ICapacityResponseMapper;
import com.pragma.bootcamp2024.domain.api.ICapacityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bootcamp")
@RequiredArgsConstructor
public class CapacityRestControllerAdapter {
    private final ICapacityRequestMapper iCapacityRequestMapper;
    private final ICapacityResponseMapper iCapacityResponseMapper;
    private final ICapacityServicePort iCapacityServicePort;

    @PostMapping("/capacity")
    public ResponseEntity<Void> addCapacity(@RequestBody AddCapacityRequest capacityRequest) {
        iCapacityServicePort.addCapacity(iCapacityRequestMapper.addRequestToCapacity(capacityRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/capacity")
    public ResponseEntity<List<CapacityResponse>> getAllCapacities() {
        return ResponseEntity.ok(iCapacityResponseMapper.toCapacityResponseList(iCapacityServicePort.getAllCapacities()));
    }
}
