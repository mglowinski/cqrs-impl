package com.mglowinski.cqrs.command.handler;

import com.mglowinski.cqrs.command.Command;

public interface CommandHandler<C extends Command> {
    void handle(C command);
}
