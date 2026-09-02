package com.during15.school.controller;

import com.during15.school.model.FeeStructure;
import com.during15.school.service.FeeStructureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fee-structures")
@CrossOrigin
public class FeeStructureController {

    private final FeeStructureService feeStructureService;

    public FeeStructureController(FeeStructureService feeStructureService) {
        this.feeStructureService = feeStructureService;
    }

    @GetMapping
    public List<FeeStructure> getAllFeeStructures() {
        return feeStructureService.getAllFeeStructures();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeeStructure> getFeeStructureById(
            @PathVariable Long id) {
        return feeStructureService.getFeeStructureById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FeeStructure createFeeStructure(
            @RequestBody FeeStructure feeStructure) {
        return feeStructureService.createFeeStructure(feeStructure);
    }

    @PutMapping("/{id}")
    public FeeStructure updateFeeStructure(
            @PathVariable Long id,
            @RequestBody FeeStructure feeStructure) {
        return feeStructureService.updateFeeStructure(id, feeStructure);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeeStructure(
            @PathVariable Long id) {
        feeStructureService.deleteFeeStructure(id);
        return ResponseEntity.noContent().build();
    }
}
