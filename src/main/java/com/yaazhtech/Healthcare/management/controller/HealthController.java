package com.yaazhtech.Healthcare.management.controller;

import com.yaazhtech.Healthcare.management.data.HealthData;
import com.yaazhtech.Healthcare.management.model.HealthInput;
import com.yaazhtech.Healthcare.management.repository.HealthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/health/management")

public class HealthController implements HealthInterface {
    @Autowired
    HealthRepository healthRepository;
    @Override
    public String healthDetail(@RequestBody HealthInput healthInput){
        HealthData healthData=new HealthData();
        healthData.setPatientName(healthInput.getPatientName());
        healthData.setPatientId(healthInput.getPatientId());
        healthData.setGender(healthInput.getGender());
        healthData.setDateOfBirth(healthInput.getDateOfBirth());
        healthData.setAdress(healthInput.getAdress());
        healthData.setContactInformation(healthInput.getContactInformation());
        healthData.setDiagnosis(healthInput.getDiagnosis());
        healthData.setAllergies(healthInput.getAllergies());
        healthRepository.save(healthData);
       // log.info("i am saved in repository");
        return "Health data have been saved successfully";

    }
    @Override
    public String managingHealth(HealthInput healthInput) {
        return null;
    }
    @Override
    @GetMapping("/allHealthData")
    public List<HealthData> getAllHealthData() {
        return healthRepository.findAll();

    }

    @Override
    @GetMapping("/{id}")
    public HealthData getPatientById(@PathVariable Long id) {
        return healthRepository.findById(id).orElse(null);

    }

    @Override
    @DeleteMapping("/{id}")
    public void deletePatientId(@PathVariable Long id) {
        healthRepository.deleteById(id);

    }

    @Override
    @PutMapping("/{id}")
    public HealthData updateData(@PathVariable Long id, @RequestBody HealthData updatedData) {

        HealthData existingData=healthRepository.findById(id).orElse(null);
        if(existingData!=null){

            existingData.setDiagnosis(updatedData.getDiagnosis());

            existingData.setContactInformation(updatedData.getContactInformation());
        }
        assert existingData != null;
        return healthRepository.save(existingData);
    }




}

