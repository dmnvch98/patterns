package org.example.patternshometask;

import lombok.Builder;
import org.example.patternshometask.requests.Request;
import org.example.patternshometask.requests.RequestObserver;

@Builder
public class Tax implements RequestObserver {
    @Override
    public void update(Request request) {
        System.out.println("Tax received information about the request ");
        request.getCommand().run();
    }
}
