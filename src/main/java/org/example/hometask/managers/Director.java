package org.example.hometask.managers;

import lombok.Builder;
import org.example.hometask.requests.Request;
import org.example.hometask.requests.RequestObserver;

import java.util.List;

@Builder
public class Director extends Manager {
    List<Manager> deputyDirectors;
    List<RequestObserver> requestObservers;

    @Override
    public boolean canHandleRequest(Request req) {
        return false;
    }

    @Override
    public Request handle(Request req) {
        Request request = deputyDirectors
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
