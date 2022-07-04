package com.vet_clinic.command.executor.appointmentsExecutors;

import com.vet_clinic.command.CommandType;
import com.vet_clinic.command.executor.AbstractCommandExecutor;
import com.vet_clinic.model.Appointment;

public class AppointmentWriter extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return writeAppointments(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_APPOINTMENTS;
    }

    private int writeAppointments(String command) {
        String[] wordsArray = command.split(" ");

        int patientId = Integer.parseInt(wordsArray[1]);

        for (Appointment appointment: appointmentRepository.findAllByPatient(patientId)) {

            System.out.printf("Patient ID: %s. Doctor ID: %s. Date of appointment: %s. Status of appointment: %s %n",
                    appointment.getPatientId(),
                    appointment.getDoctorId(),
                    appointment.getAppointmentDate(),
                    appointment.getStatus()

            );

        }

        return 1;
    }

}
