package com.vet_clinic.command.executor;

import com.vet_clinic.command.CommandType;

public interface CommandExecutor {

    int execute(String command);

    CommandType getCommandType();
}
