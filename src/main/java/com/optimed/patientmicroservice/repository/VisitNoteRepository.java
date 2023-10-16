
package com.optimed.patientmicroservice.repository;

import com.optimed.patientmicroservice.model.VisitNote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitNoteRepository extends JpaRepository<VisitNote, Long> {

}