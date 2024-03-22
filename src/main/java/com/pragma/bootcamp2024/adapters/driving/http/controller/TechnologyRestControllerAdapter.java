package com.pragma.bootcamp2024.adapters.driving.http.controller;

import com.pragma.bootcamp2024.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.pragma.bootcamp2024.adapters.driving.http.dto.request.UpdateTechnologyRequest;
import com.pragma.bootcamp2024.adapters.driving.http.dto.response.TechnologyResponse;
import com.pragma.bootcamp2024.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.pragma.bootcamp2024.adapters.driving.http.mapper.ITechnologyResponseMapper;
import com.pragma.bootcamp2024.domain.api.ITechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bootcamp")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {
    private final ITechnologyServicePort iTechnologyServicePort;
    private final ITechnologyRequestMapper iTechnologyRequestMapper;
    private final ITechnologyResponseMapper iTechnologyResponseMapper;

    @PostMapping("/technology")
    public ResponseEntity<Void> addTechnology(@RequestBody AddTechnologyRequest technologyRequest) {
        iTechnologyServicePort.saveTechnology(iTechnologyRequestMapper.addRequestToTechnology(technologyRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/technology/{technologyName}")
    public ResponseEntity<TechnologyResponse> getTechnology(@PathVariable String technologyName) {
        return ResponseEntity.ok(iTechnologyResponseMapper.toTechnologyResponse(iTechnologyServicePort.getTechnology(technologyName)));
    }

    @GetMapping("/technology")
    public ResponseEntity<List<TechnologyResponse>> getAllTechnologies(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(iTechnologyResponseMapper.toTechnologyResponsList(iTechnologyServicePort.getAllTechnologies(page, size)));
    }

    @GetMapping("/capacity/{capacityName}")
    public ResponseEntity<List<TechnologyResponse>> getAllTechnologiesByCapacity(@RequestParam Integer page, @RequestParam Integer size, @PathVariable String capacityName) {
        return ResponseEntity.ok(iTechnologyResponseMapper.toTechnologyResponsList(iTechnologyServicePort.getAllTechnologiesByCapacity(capacityName, page, size)));
    }

    @PutMapping("/technology")
    public ResponseEntity<TechnologyResponse> updateTechnology(@PathVariable UpdateTechnologyRequest technologyRequest) {
        return ResponseEntity.ok(iTechnologyResponseMapper.toTechnologyResponse(iTechnologyServicePort.updateTechnology(iTechnologyRequestMapper.updateRequestToTechnology(technologyRequest))));
    }

    @DeleteMapping("/technology/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable Long id) {
        iTechnologyServicePort.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
