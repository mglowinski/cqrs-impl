package com.mglowinski.cqrs.command.handler;

import com.mglowinski.cqrs.command.Command;

public interface CommandHandler<R, C extends Command> {
    R handle(C command);
}
