package com.vet_clinic.repository.impl;

import com.vet_clinic.model.Patient;
import com.vet_clinic.repository.PatientRepository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PatientRepositoryImpl implements PatientRepository {

    private static final Set<Patient> PATIENTS = new HashSet<>();

    private static final PatientRepositoryImpl SINGLETON = new PatientRepositoryImpl();

    public Set<Patient> foundPatient;

    PatientRepositoryImpl() {}

    public static PatientRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public void save(Patient patient) {
        PATIENTS.add(patient);
    }

    @Override
    public Set<Patient> findAll() {
        return PATIENTS;
    }

    @Override
    public void remove(Patient patient) {
        PATIENTS.remove(patient);
    }

    @Override
    public void changeName(Patient patient, Patient newPatient){
        PATIENTS.remove(patient);
        save(newPatient);
    }

}
