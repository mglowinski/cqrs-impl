package com.mglowinski.cqrs.command.bus;

import com.mglowinski.cqrs.command.Command;
import com.mglowinski.cqrs.command.CommandRegistry;
import com.mglowinski.cqrs.command.handler.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandBusImpl implements CommandBus {

    private final CommandRegistry commandRegistry;

    @Override
    public <C extends Command> void execute(C command) {
        CommandHandler<C> commandHandler = (CommandHandler<C>) commandRegistry.getCommandHandler(command.getClass());
        commandHandler.handle(command);
    }

}
