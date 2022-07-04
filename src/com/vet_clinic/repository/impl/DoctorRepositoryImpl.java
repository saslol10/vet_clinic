package com.vet_clinic.repository.impl;

import com.vet_clinic.model.Doctor;
import com.vet_clinic.model.Patient;
import com.vet_clinic.repository.DoctorRepository;
import com.vet_clinic.repository.PatientRepository;

import java.util.HashSet;
import java.util.Set;

public class DoctorRepositoryImpl implements DoctorRepository {

    private static  final Set<Doctor> DOCTORS = new HashSet<>();

    private static final DoctorRepositoryImpl SINGLETON = new DoctorRepositoryImpl();

    private DoctorRepositoryImpl() {}

    public static DoctorRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public void save(Doctor doctor) {
        DOCTORS.add(doctor);
    }

    @Override
    public Set<Doctor> findAll() {
        return DOCTORS;
    }
}
