package com.mglowinski.cqrs.command.bus;

import com.mglowinski.cqrs.command.Command;

public interface CommandBus {
    <R, C extends Command> R execute(C command);
}
