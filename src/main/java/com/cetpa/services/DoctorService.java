package com.cetpa.services;

import java.util.List;

import javax.validation.Valid;

import com.cetpa.entities.Doctor;

public interface DoctorService 
{
	Doctor createDoctor(@Valid Doctor doctor);
	Doctor getDoctorbyId(int did);
	List<Doctor> getListByCity(String city);
	List<Doctor> getListByCityAndSpeciality(String city,String speciality);
}
