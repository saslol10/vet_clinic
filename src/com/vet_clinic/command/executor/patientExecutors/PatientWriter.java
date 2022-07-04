package com.vet_clinic.command.executor.patientExecutors;

import com.vet_clinic.command.CommandType;
import com.vet_clinic.command.executor.AbstractCommandExecutor;
import com.vet_clinic.model.Patient;

public class PatientWriter extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return writePatients(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_PATIENTS;
    }

    private int writePatients(String command) {
        for (Patient patient: patientRepository.findAll()) {

            System.out.printf("ID: %s. Name: %s %s %s. Date of Registration: %s. %n",
                    patient.getId(),
                    patient.getSurname(),
                    patient.getName(),
                    patient.getMiddleName(),
                    patient.getRegistrationDate());
        }

        return 1;
    }
}
