
package com.optimed.patientmicroservice.repository;

import com.optimed.patientmicroservice.model.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {

}