package com.cetpa.resrtcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.entities.Doctor;
import com.cetpa.services.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctorRestController 
{
	@Autowired private DoctorService doctorService;
	
	@PostMapping("create")
	public ResponseEntity<Doctor> createDoctorResource(@Valid @RequestBody Doctor doctor)
	{
		Doctor doctor1=doctorService.createDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(doctor1);
	}
	@GetMapping("details/byid")
	public ResponseEntity<Doctor> getDoctorResourceById(@RequestParam int did)
	{
		Doctor doctor=doctorService.getDoctorbyId(did);
		return ResponseEntity.status(HttpStatus.OK).body(doctor);
	}
	@GetMapping("list/bycity/{city}")
	public ResponseEntity<List<Doctor>> getDoctorListByCity(@PathVariable String city)
	{
		List<Doctor> doctorList=doctorService.getListByCity(city);
		return ResponseEntity.status(HttpStatus.OK).body(doctorList);
	}
	@GetMapping("list/bycity-speciality")
	public ResponseEntity<List<Doctor>> getDoctorListByCityAndSpeciality(@RequestParam String city,@RequestParam String speciality)
	{
		List<Doctor> doctorList=doctorService.getListByCityAndSpeciality(city,speciality);
		return ResponseEntity.status(HttpStatus.OK).body(doctorList);
	}
}
