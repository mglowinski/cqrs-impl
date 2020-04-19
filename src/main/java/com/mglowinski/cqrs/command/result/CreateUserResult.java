package com.mglowinski.cqrs.command.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserResult {

    private long id;
    private String firstName;
    private String lastName;
}
