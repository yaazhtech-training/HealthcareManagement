package com.yaazhtech.Healthcare.management.repository;

import com.yaazhtech.Healthcare.management.data.HealthData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HealthRepository extends JpaRepository<HealthData,Long> {

}
