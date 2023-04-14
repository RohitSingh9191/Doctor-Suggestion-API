package com.cetpa.services;

import java.util.List;

import javax.validation.Valid;

import com.cetpa.entities.Doctor;
import com.cetpa.entities.Patient;

public interface PatientService 
{
	Patient savePatient(@Valid Patient patient);
	List<Doctor> getDoctorList(int pid);
}
