package com.vet_clinic.command.executor.doctorExecutors;

import com.vet_clinic.command.CommandType;
import com.vet_clinic.command.executor.AbstractCommandExecutor;
import com.vet_clinic.model.Doctor;

public class DoctorCreator extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return createDoctor(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_DOCTOR;
    }

    private int createDoctor(String command) {

        String[] wordsArray = command.split(" ");

        int doctorId = Integer.parseInt(wordsArray[2]);

        if (findDoctorById(doctorId).isPresent()) {
            System.out.println("Doctor with this id already exists!");
            return -1;
        }

        String doctorName = wordsArray[3];

        Doctor doctor = new Doctor(doctorId, doctorName);
        doctorRepository.save(doctor);

        System.out.println("New doctor created.");

        return 1;
    }

}