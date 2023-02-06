package org.example.hometask;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
@AllArgsConstructor
public class Request {
    String description;
    RequestType requestType;

    @Override
    public String toString() {
        return description + "-" + requestType;
    }
}
