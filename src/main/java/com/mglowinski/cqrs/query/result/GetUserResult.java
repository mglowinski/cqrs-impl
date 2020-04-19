package com.mglowinski.cqrs.query.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetUserResult {

    private long id;
    private String firstName;
    private String lastName;
}
