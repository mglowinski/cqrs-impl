package com.mglowinski.cqrs.query.bus;

import com.mglowinski.cqrs.query.Query;

public interface QueryBus {
    <R, Q extends Query> R execute(Q query);
}
