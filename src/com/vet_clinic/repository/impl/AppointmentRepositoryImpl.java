package com.vet_clinic.repository.impl;

import com.vet_clinic.model.Appointment;
import com.vet_clinic.model.Patient;
import com.vet_clinic.repository.AppointmentRepository;
import com.vet_clinic.repository.PatientRepository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AppointmentRepositoryImpl implements AppointmentRepository {

    private static  final Set<Appointment> APPOINTMENTS = new HashSet<>();

    private static final AppointmentRepositoryImpl SINGLETON = new AppointmentRepositoryImpl();

    private AppointmentRepositoryImpl() {}

    public static AppointmentRepository getSingleton() {
        return SINGLETON;
    }

    @Override
    public void save(Appointment appointment) {
        APPOINTMENTS.add(appointment);
    }

    @Override
    public Set<Appointment> findAll(){
        return APPOINTMENTS;
    }

    public Set<Appointment> findAllByPatient(int patientId) { //проход итератором по Set, скорее всего есть решение лучше -> todo
        Set<Appointment> foundAppointments = new HashSet<>();
        for (Iterator<Appointment> it = APPOINTMENTS.iterator(); it.hasNext();) {
            Appointment iterator = it.next();
            if (iterator.getPatientId().equals(patientId))
            {
                foundAppointments.add(iterator);
            };
        }
        return foundAppointments;
    }

    @Override
    public void changeStatus(Appointment appointment, Appointment newAppointment){
        APPOINTMENTS.remove(appointment);
        save(newAppointment);
    }
}
