package com.vet_clinic.command.executor.doctorExecutors;

import com.vet_clinic.command.CommandType;
import com.vet_clinic.command.executor.AbstractCommandExecutor;
import com.vet_clinic.model.Doctor;

//Класс создан для (удобства) отслеживания созданных докторов
public class DoctorWriter extends AbstractCommandExecutor {

    @Override
    public int execute(String command) {
        return writeDoctors(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_DOCTORS;
    }

    private int writeDoctors(String command) {
        for (Doctor doctor: doctorRepository.findAll()) {

            System.out.printf("ID: %s. Name: %s. %n",
                    doctor.getId(),
                    doctor.getName()
                    );
        }

        return 1;
    }
}