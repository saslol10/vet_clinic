package com.vet_clinic.repository;

import com.vet_clinic.model.Doctor;
import com.vet_clinic.model.Patient;

import java.util.Set;

public interface DoctorRepository {

    void save(Doctor patient);

    Set<Doctor> findAll();

}
