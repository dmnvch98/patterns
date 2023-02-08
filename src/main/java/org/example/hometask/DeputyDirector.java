package org.example.hometask;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

public class DeputyDirector implements RequestHandler {
    List<Administrator> allAdministrators;
    Administrator canHandleRequestAdministrator;

    @Builder
    public DeputyDirector() {
        allAdministrators = Arrays.asList(
            Administrator.builder().name("1").build(),
            Administrator.builder().name("2").build()
        );
    }

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
