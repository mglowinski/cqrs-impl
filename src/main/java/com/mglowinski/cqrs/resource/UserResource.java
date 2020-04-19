package com.mglowinski.cqrs.resource;

import com.mglowinski.cqrs.query.bus.QueryBus;
import com.mglowinski.cqrs.query.impl.GetUserQuery;
import com.mglowinski.cqrs.query.result.GetUserResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserResource {

    private final QueryBus queryBus;

    @GetMapping("/{id}")
    public GetUserResult getUser(@PathVariable Long id) {
        return queryBus.execute(new GetUserQuery(id));
    }

}
