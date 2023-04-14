package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cetpa.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer> 
{
}
