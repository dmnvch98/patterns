package org.example.patternshometask.managers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.patternshometask.requests.RequestHandler;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
public abstract class Manager implements RequestHandler {
    @Getter
    List<Manager> managers;
}
