package org.example.patternshometask.managers;

import lombok.Builder;
import lombok.Value;
import org.example.patternshometask.requests.Request;

@Builder
@Value
public class Founder {
    Manager director;

    public void sendRequest(Request request) {
        director.handle(request);
    }

}
