package com.mglowinski.cqrs.command;

import com.mglowinski.cqrs.command.handler.CommandHandler;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class CommandRegistry {

    private Map<Class<? extends Command>, CommandHandler<?>> commandHandlerMap = new HashMap<>();

    public CommandRegistry(Set<CommandHandler<?>> commandHandlers) {
        createRegistry(commandHandlers);
    }

    public CommandHandler<?> getCommandHandler(Class<?> commandClass) {
        return commandHandlerMap.get(commandClass);
    }

    private void createRegistry(Set<CommandHandler<?>> commandHandlers) {
        commandHandlers.forEach(commandHandler -> {
            Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(
                    commandHandler.getClass(), CommandHandler.class);
            Class<? extends Command> commandClass = (Class<? extends Command>) generics[0];
            commandHandlerMap.put(commandClass, commandHandler);
        });
    }

}
