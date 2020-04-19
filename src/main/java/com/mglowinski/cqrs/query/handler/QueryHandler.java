package com.mglowinski.cqrs.query.handler;

import com.mglowinski.cqrs.query.Query;

public interface QueryHandler<R, Q extends Query> {
    R handle(Q query);
}
