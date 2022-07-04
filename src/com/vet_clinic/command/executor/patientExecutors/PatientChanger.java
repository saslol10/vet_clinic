package com.vet_clinic.command.executor.patientExecutors;

import com.vet_clinic.command.CommandType;
import com.vet_clinic.command.executor.AbstractCommandExecutor;
import com.vet_clinic.model.Patient;

import java.util.Optional;

public class PatientChanger extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return changePatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CHANGE_PATIENT;    }

    private int changePatient(String command) {
        var wordsArray = command.split(" ");

        int patientIdToChange = Integer.parseInt(wordsArray[2]);

        String newPatientSurname = wordsArray[3];
        String newPatientName = wordsArray[4];
        String newPatientMiddleName = wordsArray[5];

        Patient newPatient = new Patient(patientIdToChange, newPatientSurname, newPatientName, newPatientMiddleName);

        Optional<Patient> patientToChange = findPatientById(patientIdToChange);

        if (patientToChange.isPresent()) {
            if (findPatientByName(newPatientSurname, newPatientName, newPatientMiddleName).isPresent()) {
                System.out.println("Patient with this name already exists!");
                return -1;
            }
            patientRepository.changeName(patientToChange.get(), newPatient);
            System.out.println("Patient changed.");
        } else {
            System.out.println("Patient not found.");
        }

        return 1;
    }
}
