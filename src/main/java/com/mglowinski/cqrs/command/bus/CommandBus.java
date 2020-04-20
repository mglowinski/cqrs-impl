package com.mglowinski.cqrs.command.bus;

import com.mglowinski.cqrs.command.Command;

public interface CommandBus {
    <C extends Command> void execute(C command);
}
