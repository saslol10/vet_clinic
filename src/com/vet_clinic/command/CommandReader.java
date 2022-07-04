package com.vet_clinic.command;

import com.vet_clinic.command.executor.*;
import com.vet_clinic.command.executor.appointmentsExecutors.AppointmentChanger;
import com.vet_clinic.command.executor.appointmentsExecutors.AppointmentCreator;
import com.vet_clinic.command.executor.appointmentsExecutors.AppointmentWriter;
import com.vet_clinic.command.executor.doctorExecutors.DoctorCreator;
import com.vet_clinic.command.executor.doctorExecutors.DoctorWriter;
import com.vet_clinic.command.executor.patientExecutors.PatientChanger;
import com.vet_clinic.command.executor.patientExecutors.PatientCreator;
import com.vet_clinic.command.executor.patientExecutors.PatientDeleter;
import com.vet_clinic.command.executor.patientExecutors.PatientWriter;

import java.util.Map;
import java.util.Scanner;

public class CommandReader {

    //требует доработки -> todo
    private static final Map<CommandType, CommandExecutor> COMMAND_EXECUTORS_GROUPED_BY_COMMAND = Map.of(
            CommandType.CREATE_PATIENT, new PatientCreator(),
            CommandType.DELETE_PATIENT, new PatientDeleter(),
            CommandType.WRITE_ALL_PATIENTS, new PatientWriter(),
            CommandType.CHANGE_PATIENT, new PatientChanger(),
            CommandType.CREATE_DOCTOR, new DoctorCreator(),
            CommandType.WRITE_ALL_DOCTORS, new DoctorWriter(),
            CommandType.CREATE_APPOINTMENT, new AppointmentCreator(),
            CommandType.CHANGE_APPOINTMENT, new AppointmentChanger(),
            CommandType.WRITE_ALL_APPOINTMENTS, new AppointmentWriter()
    );

    public static void startReading() {
        System.out.println("Hello! :) Program started. ");
        Scanner s = new Scanner(System.in);
        //бесконечный цикл
        int i = 1;
        while (i != 0) {
            System.out.println("Write your command, please: ");
            i = readCommand(s);
        }
        s.close();
    }

    /**
     * Available commands:
     * - "create patient patient-id patient-surname patient-name patient-middleName", patient-id - only positive int number, patient-surname - only 1 word, patient-name - only 1 word, patient-middleName - only 1 word or '-' if middleName is missing;
     * - "delete patient patient-id";
     * - "change patient patient-id patient-surname patient-name patient-middleName";
     * - "patients" - to view all patients;
     * - "create doctor doctor-id doctor-name", doctor-id - only positive int number, doctor-name - only 1 word;
     * - "doctors" - to view all doctors;
     * - "create appointment patient-id doctor-id appointment-date", appointment-date - recommend format: yyyy-MM-dd_HH:mm;
     * - "change appointment patient-id doctor-id appointment-date appointment-status", appointment-status: Новый, В процессе, Отменен, Ожидает оплаты, Завершен ;
     * - "appointments patient-id" - to view all patient appointments;
     * - "exit" - program exits.
     */

    private static int readCommand(Scanner s) {

        var commandString = s.nextLine();

        CommandType commandType = getCommandType(commandString);

        if (COMMAND_EXECUTORS_GROUPED_BY_COMMAND.containsKey(commandType)) {
            var commandExecutor = COMMAND_EXECUTORS_GROUPED_BY_COMMAND.get(commandType);
            return commandExecutor.execute(commandString);
        }

        if (commandType == CommandType.EXIT) {
            System.out.println("Program exits. Goodbye, see you soon! :)");
            return 0;
        }

        System.out.println("Incorrect command");
        return -1;

    }

    private static CommandType getCommandType(String commandString) {
        if (commandString.contains("create patient")) {
            return CommandType.CREATE_PATIENT;
        }
        if (commandString.contains("create doctor")) {
            return CommandType.CREATE_DOCTOR;
        }

        if (commandString.contains("create appointment")) {
            return CommandType.CREATE_APPOINTMENT;
        }

        if (commandString.contains("change patient")) {
            return CommandType.CHANGE_PATIENT;
        }

        if (commandString.contains("change appointment")) {
            return CommandType.CHANGE_APPOINTMENT;
        }

        if (commandString.contains("delete patient")) {
            return CommandType.DELETE_PATIENT;
        }

        if (commandString.contains("patients")) {
            return CommandType.WRITE_ALL_PATIENTS;
        }

        if (commandString.contains("doctors")) {
            return CommandType.WRITE_ALL_DOCTORS;
        }

        if (commandString.contains("appointments")) {
            return CommandType.WRITE_ALL_APPOINTMENTS;
        }

        if (commandString.contains("exit")) {
            return CommandType.EXIT;
        }

        return CommandType.UNDEFINED;
    }

}
