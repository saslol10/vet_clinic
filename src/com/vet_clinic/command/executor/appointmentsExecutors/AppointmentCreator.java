package com.vet_clinic.command.executor.appointmentsExecutors;

import com.vet_clinic.command.CommandType;
import com.vet_clinic.command.executor.AbstractCommandExecutor;
import com.vet_clinic.model.Appointment;
import com.vet_clinic.model.Doctor;
import com.vet_clinic.model.Patient;

import java.util.Optional;

public class AppointmentCreator extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return createAppointment(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_APPOINTMENT;
    }

    private int createAppointment(String command) {

        String[] wordsArray = command.split(" ");

        int patientId = Integer.parseInt(wordsArray[2]);
        int doctorId = Integer.parseInt(wordsArray[3]);
        String appointmentDate = wordsArray[4];

        Optional<Patient> patientToChange = findPatientById(patientId);
        if (!patientToChange.isPresent()) {
            System.out.println("Patient not found.");
            return -1;
        }

        Optional<Doctor> doctorToChange = findDoctorById(doctorId );
        if (!doctorToChange.isPresent()) {
            System.out.println("Doctor not found.");
            return -1;
        }

        if (findAppointment(patientId, doctorId, appointmentDate).isPresent()) {
            System.out.println("Patient already have appointment with that doctor on this date/time!");
            return -1;
        }

        StringBuilder appointmentStatusSb = new StringBuilder();
        for (int i = 5; i < wordsArray.length; i++) {
            appointmentStatusSb.append(wordsArray[i]);
            appointmentStatusSb.append(" "); //костыль - пробел между словами todo
        }

        Appointment newAppointment = new Appointment(patientId, doctorId, appointmentDate);
        appointmentRepository.save(newAppointment);

        System.out.println("New appointment created");

        return 1;
    }
}
