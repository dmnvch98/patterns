package org.example.hometask.managers;

import lombok.Builder;
import org.example.hometask.requests.Request;

import java.util.List;

@Builder
public class DeputyDirector extends Manager {
    private final List<Manager> allAdministrators;
    Manager canHandleRequestAdministrator;

    @Override
    public boolean canHandleRequest(Request req) {
        canHandleRequestAdministrator = allAdministrators.stream()
            .filter(executor -> executor.canHandleRequest(req))
            .findFirst().orElse(null);
        return canHandleRequestAdministrator != null;
    }

    @Override
    public Request handle(Request req) {
        return canHandleRequestAdministrator.handle(req);
    }
}
