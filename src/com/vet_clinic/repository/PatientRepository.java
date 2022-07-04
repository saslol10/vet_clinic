package com.vet_clinic.repository;

import com.vet_clinic.model.Patient;

import java.util.Set;

public interface PatientRepository {

    void save(Patient patient);

    Set<Patient> findAll();

    void remove(Patient patient);

    void changeName(Patient patient, Patient newPatient);

}
