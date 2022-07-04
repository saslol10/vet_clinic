package com.vet_clinic.command.executor.patientExecutors;

import com.vet_clinic.command.CommandType;
import com.vet_clinic.command.executor.AbstractCommandExecutor;
import com.vet_clinic.model.Patient;

import java.util.Optional;

public class PatientDeleter extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return deletePatient(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DELETE_PATIENT;
    }

    private int deletePatient(String command) {
        var wordsArray = command.split(" ");

        int patientIdToRemove = Integer.parseInt(wordsArray[2]);

        Optional<Patient> patientToRemove = findPatientById(patientIdToRemove);

        if (patientToRemove.isPresent()) {
            patientRepository.remove(patientToRemove.get());

            System.out.println("Patient deleted.");
        } else {
            System.out.println("Patient not found.");
        }

        return 1;
    }
}
