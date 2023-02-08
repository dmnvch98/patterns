package org.example.hometask;

import lombok.Builder;

import java.util.List;

@Builder
public class DeputyDirector implements RequestHandler {
    private final List<Administrator> allAdministrators;
    Administrator canHandleRequestAdministrator;


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
