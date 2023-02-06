package org.example.hometask.executors;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.example.hometask.RequestHandler;
import org.example.hometask.executors.states.State;

@SuperBuilder
@Getter
public abstract class Executor implements RequestHandler {
    private final String name;
    private final State state;
}
