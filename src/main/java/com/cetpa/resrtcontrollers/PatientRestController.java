package com.cetpa.resrtcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.Doctor;
import com.cetpa.entities.Patient;
import com.cetpa.services.PatientService;

@RestController
@RequestMapping("patient")
public class PatientRestController 
{
	@Autowired private PatientService patientService;
	
	@PostMapping("create")
	public ResponseEntity<Patient> createResource(@Valid  @RequestBody Patient patient)
	{
		Patient patient1=patientService.savePatient(patient);
	    return ResponseEntity.status(HttpStatus.CREATED).body(patient1);
	}
	@GetMapping("doctor-list")
	public ResponseEntity<List<Doctor>> getDoctorListonPatientSymptom(@RequestParam int pid)
	{
		List<Doctor> doctorList=patientService.getDoctorList(pid);
	    return ResponseEntity.status(HttpStatus.OK).body(doctorList);
	}
}
