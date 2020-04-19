package com.mglowinski.cqrs.query;

import com.mglowinski.cqrs.query.handler.QueryHandler;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class QueryRegistry {

    private Map<Class<? extends Query>, QueryHandler<?, ?>> queryHandlerMap = new HashMap<>();

    public QueryRegistry(Set<QueryHandler<?, ?>> queryHandlers) {
        createRegistry(queryHandlers);
    }

    public QueryHandler<?, ?> getQueryHandler(Class<?> queryClass) {
        return queryHandlerMap.get(queryClass);
    }

    private void createRegistry(Set<QueryHandler<?, ?>> queryHandlers) {
        queryHandlers.forEach(queryHandler -> {
            Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(
                    queryHandler.getClass(), QueryHandler.class);
            Class<? extends Query> queryClass = (Class<? extends Query>) generics[1];
            queryHandlerMap.put(queryClass, queryHandler);
        });
    }

}
