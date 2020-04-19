package com.mglowinski.cqrs.resource;

import com.mglowinski.cqrs.command.bus.CommandBus;
import com.mglowinski.cqrs.command.impl.CreateUserCommand;
import com.mglowinski.cqrs.command.result.CreateUserResult;
import com.mglowinski.cqrs.query.bus.QueryBus;
import com.mglowinski.cqrs.query.impl.GetUserQuery;
import com.mglowinski.cqrs.query.result.GetUserResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserResource {

    private final QueryBus queryBus;
    private final CommandBus commandBus;

    @PostMapping
    public ResponseEntity<CreateUserResult> createUser(@RequestBody CreateUserCommand createUserCommand) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commandBus.execute(createUserCommand));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResult> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(queryBus.execute(new GetUserQuery(id)));
    }

}
