package com.mglowinski.cqrs.query.handler.impl;

import com.mglowinski.cqrs.query.handler.QueryHandler;
import com.mglowinski.cqrs.query.impl.GetUserQuery;
import com.mglowinski.cqrs.query.result.GetUserResult;
import com.mglowinski.cqrs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class GetUserHandler implements QueryHandler<GetUserResult, GetUserQuery> {

    private final UserRepository userRepository;

    @Override
    public GetUserResult handle(GetUserQuery query) {
        return userRepository.findById(query.getId())
                .map(user -> new GetUserResult(user.getId()))
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

}
