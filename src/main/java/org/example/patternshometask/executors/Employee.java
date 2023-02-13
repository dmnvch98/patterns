package org.example.patternshometask.executors;

import lombok.experimental.SuperBuilder;
import org.example.patternshometask.executors.states.WorkState;
import org.example.patternshometask.requests.Request;
import org.example.patternshometask.requests.RequestType;

@SuperBuilder
public class Employee extends Executor {

    private final String name;

    @Override
    public boolean canHandleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.EMPLOYEE_REQUEST)) {
            return getState().getClass().equals(WorkState.class);
        }
        return false;
    }

    @Override
    public Request handle(Request req) {
        System.out.println("Employee " + name + " executed task: ");
        req.getCommand().run();
        req.setCompleted(true);
        return req;
    }
}