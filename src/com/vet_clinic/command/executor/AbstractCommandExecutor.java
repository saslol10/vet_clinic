package com.vet_clinic.command.executor;

import com.vet_clinic.model.Appointment;
import com.vet_clinic.model.Doctor;
import com.vet_clinic.model.Patient;
import com.vet_clinic.repository.AppointmentRepository;
import com.vet_clinic.repository.DoctorRepository;
import com.vet_clinic.repository.PatientRepository;
import com.vet_clinic.repository.impl.AppointmentRepositoryImpl;
import com.vet_clinic.repository.impl.DoctorRepositoryImpl;
import com.vet_clinic.repository.impl.PatientRepositoryImpl;

import java.util.Optional;

public abstract class AbstractCommandExecutor implements CommandExecutor {


    protected final PatientRepository patientRepository = PatientRepositoryImpl.getSingleton();

    protected final DoctorRepository doctorRepository = DoctorRepositoryImpl.getSingleton();

    protected final AppointmentRepository appointmentRepository = AppointmentRepositoryImpl.getSingleton();


    protected Optional<Patient> findPatientById(int id) {
        for (Patient patient : patientRepository.findAll()) {
            if (patient.getId().equals(id)) {
                return Optional.of(patient);
            }
        }

        return Optional.empty();
    }

    protected Optional<Patient> findPatientByName(String surname, String name, String middleName) {
        for (Patient patient : patientRepository.findAll()) {
            if (patient.getSurname().equals(surname) && patient.getName().equals(name) && patient.getMiddleName().equals(middleName)) {
                return Optional.of(patient);
            }
        }

        return Optional.empty();
    }

    protected Optional<Doctor> findDoctorById(Integer id) {
        for (Doctor doctor : doctorRepository.findAll()) {
            if (doctor.getId().equals(id)) {
                return Optional.of(doctor);
            }
        }

        return Optional.empty();
    }

    protected Optional<Appointment> findAppointment(int appointmentPatientId, int appointmentDoctorId, String appointmentDate) {
        for (Appointment appointment : appointmentRepository.findAll()){
            if (appointment.getPatientId().equals(appointmentPatientId)
                    && appointment.getDoctorId().equals(appointmentDoctorId)
                    && appointment.getAppointmentDate().equals(appointmentDate)) {
                return Optional.of(appointment);
            }
        }
        return Optional.empty();
    }

    protected Optional<Appointment> findAppointment(int appointmentPatientId, int appointmentDoctorId, String appointmentDate, String appointmentStatus) {
        for (Appointment appointment : appointmentRepository.findAll()) {
            if (appointment.getPatientId().equals(appointmentPatientId)
                    && appointment.getDoctorId().equals(appointmentDoctorId)
                    && appointment.getAppointmentDate().equals(appointmentDate)
                    && appointment.getStatus().equals(appointmentStatus)) {
                return Optional.of(appointment);
            }
        }
        return Optional.empty();
    }
}
