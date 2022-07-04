package com.vet_clinic.command.executor.patientExecutors;

import com.vet_clinic.command.CommandType;
import com.vet_clinic.command.executor.AbstractCommandExecutor;
import com.vet_clinic.model.Patient;

public class PatientCreator extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return createPatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_PATIENT;
    }

    private int createPatient(String command) {

        String[] wordsArray = command.split(" ");

        int patientId = Integer.parseInt(wordsArray[2]);

        if (findPatientById(patientId).isPresent()) {
            System.out.println("Patient with this id already exists!");
            return -1;
        }


        String patientSurname = wordsArray[3];
        String patientName = wordsArray[4];
        String patientMiddleName = wordsArray[5];

        if (findPatientByName(patientSurname, patientName, patientMiddleName).isPresent()) {
            System.out.println("Patient with this name already exists!");
            return -1;
        }

        Patient newPatient = new Patient(patientId, patientSurname, patientName, patientMiddleName);
        patientRepository.save(newPatient);

        System.out.println("New patient created.");

        return 1;
    }

}
