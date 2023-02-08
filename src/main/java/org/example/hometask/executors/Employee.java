package org.example.hometask.executors;

import lombok.experimental.SuperBuilder;
import org.example.hometask.Request;
import org.example.hometask.RequestType;
import org.example.hometask.executors.states.WorkState;

@SuperBuilder
public class Employee extends Executor {

    @Override
    public boolean canHandleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.EMPLOYEE_REQUEST)) {
            return super.getState().getClass().equals(WorkState.class);
        }
        return false;
    }

    @Override
    public Request handle(Request req) {
        System.out.println("Employee " + super.getName() + " executed task: ");
        req.getCommand().run();
        req.setCompleted(true);
        return req;
    }
}
