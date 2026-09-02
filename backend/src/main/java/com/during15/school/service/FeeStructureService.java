package com.during15.school.service;

import com.during15.school.model.FeeStructure;
import com.during15.school.repository.FeeStructureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeeStructureService {

    private final FeeStructureRepository feeStructureRepository;

    public FeeStructureService(FeeStructureRepository feeStructureRepository) {
        this.feeStructureRepository = feeStructureRepository;
    }

    public List<FeeStructure> getAllFeeStructures() {
        return feeStructureRepository.findAll();
    }

    public Optional<FeeStructure> getFeeStructureById(Long id) {
        return feeStructureRepository.findById(id);
    }

    public FeeStructure createFeeStructure(FeeStructure feeStructure) {
        return feeStructureRepository.save(feeStructure);
    }

    public FeeStructure updateFeeStructure(Long id, FeeStructure details) {
        FeeStructure feeStructure = feeStructureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fee structure not found"));

        feeStructure.setFeeName(details.getFeeName());
        feeStructure.setAmount(details.getAmount());
        feeStructure.setDescription(details.getDescription());

        return feeStructureRepository.save(feeStructure);
    }

    public void deleteFeeStructure(Long id) {
        feeStructureRepository.deleteById(id);
    }
}
