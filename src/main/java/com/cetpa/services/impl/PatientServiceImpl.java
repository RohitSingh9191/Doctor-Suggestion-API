package com.cetpa.services.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Doctor;
import com.cetpa.entities.Patient;
import com.cetpa.exception.RecordNotFoundException;
import com.cetpa.map.SymptomSpecialityMap;
import com.cetpa.repositories.DoctorRepository;
import com.cetpa.repositories.PatientRepository;
import com.cetpa.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService
{
	@Autowired private PatientRepository patientRepository;
	@Autowired private DoctorRepository doctorRepository;

	public Patient savePatient(@Valid Patient patient) 
	{
		return patientRepository.save(patient);
	}
	public List<Doctor> getDoctorList(int pid) 
	{
		Patient patient=patientRepository.findById(pid).orElse(null);
		if(patient==null)
			throw new RecordNotFoundException("Patient with id "+pid+" does not exist");
		String city=patient.getCity();
		if(!city.equals("Noida") && !city.equals("Delhi") && !city.equals("Faridabad"))
			throw new RecordNotFoundException("We are still waiting to expand to your location");
		String symptom=patient.getSymptom();
		System.out.println(symptom);
		String speciality=SymptomSpecialityMap.map.get(symptom);
		System.out.println(speciality);
		List<Doctor> doctorList=doctorRepository.findByCityAndSpeciality(city, speciality);
		if(doctorList.isEmpty())
			throw new RecordNotFoundException("There isn’t any doctor present at your location for your symptom"); 
		return doctorList;
	} 
}
