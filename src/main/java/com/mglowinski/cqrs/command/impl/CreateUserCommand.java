package com.mglowinski.cqrs.command.impl;

import com.mglowinski.cqrs.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserCommand implements Command {

    private String firstName;
    private String lastName;
}
