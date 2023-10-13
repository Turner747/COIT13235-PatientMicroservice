
package com.optimed.patientmicroservice.repository;

import com.optimed.patientmicroservice.model.Condition;
import com.optimed.patientmicroservice.model.Patient;
import com.optimed.patientmicroservice.model.VisitNote;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitNoteRepository extends JpaRepository<VisitNote, Long> {

}