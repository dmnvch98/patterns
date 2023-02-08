package org.example.hometask;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

public class Director implements RequestHandler {
    List<DeputyDirector> deputyDirectors;
    @Builder
    public Director() {
        deputyDirectors = Arrays.asList(
            DeputyDirector.builder().build(),
            DeputyDirector.builder().build()
        );
    }

    @Override
    public boolean canHandleRequest(Request req) {
        return false;
    }

    @Override
    public Request handle(Request req) {
        return deputyDirectors
            .stream()
            .filter(handler -> handler.canHandleRequest(req))
            .findFirst()
            .map(handler -> handler.handle(req))
            .orElse(req);
    }
}
