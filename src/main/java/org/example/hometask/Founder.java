package org.example.hometask;

import lombok.Builder;

@Builder
public class Founder {
    private final Director director;

    public Request sendCommand(Request request) {
        return director.handle(request);
    }

    public void getCommand() {}

}
