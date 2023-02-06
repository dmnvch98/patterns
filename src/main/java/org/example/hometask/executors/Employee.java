package org.example.hometask.executors;

import lombok.experimental.SuperBuilder;
import org.example.hometask.ExecutorStatus;
import org.example.hometask.Request;
import org.example.hometask.RequestType;
import org.example.hometask.executors.states.WorkState;

@SuperBuilder
public class Employee extends Executor {

    @Override
    public boolean canHandleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.EMPLOYEE_REQUEST)) {
            if (super.getState().getClass().equals(WorkState.class)) {
                return true;
            }
            System.out.println("Employee cannot make this task. Their status is " + super.getState().observe());
        }
        return false;
    }

    @Override
    public void handle(Request req) {
        System.out.println("Employee executed task: " + req.getDescription());
    }
}
