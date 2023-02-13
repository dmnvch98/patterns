package org.example.patternshometask.managers;

import lombok.experimental.SuperBuilder;
import org.example.patternshometask.requests.Request;
import org.example.patternshometask.requests.RequestObserver;

import java.util.List;

@SuperBuilder
public class Director extends Manager {
    List<RequestObserver> requestObservers;

    @Override
    public boolean canHandleRequest(Request req) {
        return false;
    }

    @Override
    public Request handle(Request req) {
        Request request = managers
            .stream()
            .filter(handler -> handler.canHandleRequest(req))
            .findFirst()
            .map(handler -> handler.handle(req))
            .orElse(req);
        if (request.isCompleted()) {
            requestObservers.forEach(requestObserver -> requestObserver.update(request));
        }
        return request;
    }
}
