package com.vet_clinic.command.executor.appointmentsExecutors;

import com.vet_clinic.command.CommandType;
import com.vet_clinic.command.executor.AbstractCommandExecutor;
import com.vet_clinic.model.Appointment;

import java.util.Optional;

public class AppointmentChanger extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return changeAppointment(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CHANGE_APPOINTMENT;
    }

    private int changeAppointment(String command) {

        String[] wordsArray = command.split(" ");

        int patientIdToChange = Integer.parseInt(wordsArray[2]);
        int doctorIdToChange = Integer.parseInt(wordsArray[3]);
        String appointmentDateToChange = wordsArray[4];

        StringBuilder newAppointmentStatusSb = new StringBuilder();
        for (int i = 5; i < wordsArray.length; i++) {
            newAppointmentStatusSb.append(wordsArray[i]);
            newAppointmentStatusSb.append(" ");//костыль - добавка пробела todo
        }
        String newAppointmentStatus = newAppointmentStatusSb.toString();
        if(!newAppointmentStatus.equals("Новый ")
                && !newAppointmentStatus.equals("В процессе ")
                && !newAppointmentStatus.equals("Отменен ")
                && !newAppointmentStatus.equals("Ожидает оплаты ")
                && !newAppointmentStatus.equals("Завершен "))
        {
            System.out.println("Appointment status incorrect!");
            return -1;
        }

        Appointment newAppointment = new Appointment(patientIdToChange, doctorIdToChange, appointmentDateToChange, newAppointmentStatus);

        Optional<Appointment> appointmentToChange = findAppointment(patientIdToChange, doctorIdToChange, appointmentDateToChange);

        if (appointmentToChange.isPresent()) {
            if (findAppointment(patientIdToChange, doctorIdToChange, appointmentDateToChange, newAppointmentStatus).isPresent()) {
                System.out.println("Status is already like this!");
                return -1;
            }
            appointmentRepository.changeStatus(appointmentToChange.get(), newAppointment);
            System.out.printf("Status appointment changed to %s %n", newAppointmentStatus);
        } else {
            System.out.println("Appointment not found.");
        }

        return 1;
    }

}
