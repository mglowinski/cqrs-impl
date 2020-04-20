package com.mglowinski.cqrs.command.handler.impl;

import com.mglowinski.cqrs.command.handler.CommandHandler;
import com.mglowinski.cqrs.command.impl.CreateUserCommand;
import com.mglowinski.cqrs.model.User;
import com.mglowinski.cqrs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserHandler implements CommandHandler<CreateUserCommand> {

    private final UserRepository userRepository;

    @Override
    public void handle(CreateUserCommand command) {
        User user = User.builder()
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .build();

        userRepository.save(user);
    }

}
