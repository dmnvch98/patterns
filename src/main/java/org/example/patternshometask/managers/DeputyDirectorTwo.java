package org.example.patternshometask.managers;

import lombok.experimental.SuperBuilder;
import org.example.patternshometask.requests.Request;

@SuperBuilder
public class DeputyDirectorTwo extends Manager {
    Manager canHandleRequestAdministrator;

    @Override
    public boolean canHandleRequest(Request req) {
        canHandleRequestAdministrator = managers.stream()
            .filter(executor -> executor.canHandleRequest(req))
            .findFirst().orElse(null);
        return canHandleRequestAdministrator != null;
    }

    @Override
    public Request handle(Request req) {
        return canHandleRequestAdministrator.handle(req);
    }
}
