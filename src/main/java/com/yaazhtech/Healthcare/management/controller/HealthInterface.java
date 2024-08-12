package com.yaazhtech.Healthcare.management.controller;

import com.yaazhtech.Healthcare.management.data.HealthData;
import com.yaazhtech.Healthcare.management.model.HealthInput;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface HealthInterface {
    @PostMapping("/save")
    String healthDetail(@RequestBody HealthInput healthInput);

    String managingHealth(HealthInput healthInput);

    @GetMapping("/allHealthData")
    List<HealthData> getAllHealthData();

    @GetMapping("/{id}")
    HealthData getPatientById(@PathVariable Long id);

    @DeleteMapping("/{id}")
    void deletePatientId(@PathVariable Long id);

    @PutMapping("/{id}")
    HealthData updateData(@PathVariable Long id, @RequestBody HealthData updatedData);
}
