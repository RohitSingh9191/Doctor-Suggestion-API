package com.cetpa.services.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Doctor;
import com.cetpa.exception.RecordNotFoundException;
import com.cetpa.repositories.DoctorRepository;
import com.cetpa.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService 
{
	@Autowired private DoctorRepository doctorRepository;

	public Doctor createDoctor(@Valid Doctor doctor) 
	{
		return doctorRepository.save(doctor);
	}
	public Doctor getDoctorbyId(int did) 
	{
		Doctor doctor=doctorRepository.findById(did).orElse(null);
		if(doctor==null)
		{
			throw new RecordNotFoundException("Doctor with id "+did+" not found");
		}
		return doctor; 
	}
	public List<Doctor> getListByCity(String city) 
	{
		List<Doctor> doctorList=doctorRepository.findByCity(city);
		if(doctorList.isEmpty())
		{
			throw new RecordNotFoundException("No doctors exist in city "+city);
		}
		return doctorList;
	}
	public List<Doctor> getListByCityAndSpeciality(String city,String speciality) 
	{
		List<Doctor> doctorList=doctorRepository.findByCityAndSpeciality(city, speciality);
		if(doctorList.isEmpty())
		{
			throw new RecordNotFoundException("No doctors exist");
		}
		return doctorList;
	} 
}
