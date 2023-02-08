package org.example.hometask;

import lombok.Builder;

public class Founder {
    private final Director director;

    public Request sendCommand(Request request) {
        return director.handle(request);
    }

    public void getCommand() {}

    @Builder
    public Founder() {
        this.director = Director.builder().build();
    }
}
