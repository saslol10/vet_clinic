package com.vet_clinic.repository;

import com.vet_clinic.model.Appointment;
import com.vet_clinic.model.Patient;

import java.util.Set;

public interface AppointmentRepository {

    void save(Appointment appointment);

    Set<Appointment> findAll();

    Set<Appointment> findAllByPatient(int patientId);

    void changeStatus(Appointment appointment, Appointment newAppointment);

}
