package com.mglowinski.cqrs.query.impl;

import com.mglowinski.cqrs.query.Query;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserQuery implements Query {

    private Long id;
}
