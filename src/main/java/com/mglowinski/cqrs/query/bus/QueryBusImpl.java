package com.mglowinski.cqrs.query.bus;

import com.mglowinski.cqrs.query.Query;
import com.mglowinski.cqrs.query.QueryRegistry;
import com.mglowinski.cqrs.query.handler.QueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueryBusImpl implements QueryBus {

    private final QueryRegistry queryRegistry;

    @Override
    public <R, Q extends Query> R execute(Q query) {
        QueryHandler<R, Q> queryHandler = (QueryHandler<R, Q>) queryRegistry.getQueryHandler(query.getClass());
        return queryHandler.handle(query);
    }

}
