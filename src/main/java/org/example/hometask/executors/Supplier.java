package org.example.hometask.executors;

import lombok.experimental.SuperBuilder;
import org.example.hometask.Request;
import org.example.hometask.RequestType;
import org.example.hometask.executors.states.WorkState;

@SuperBuilder
public class Supplier extends Executor {
    @Override
    public boolean canHandleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.SUPPLIER_REQUEST)) {
            if (super.getState().getClass().equals(WorkState.class)) {
                return true;
            }
            System.out.println("Supplier " + super.getName() + " cannot make this task. Their status is " + super.getState().observe());
        }
        return false;
    }

    @Override
    public void handle(Request req) {
        System.out.println("Supplier " + super.getName() + " executed task: " + req.getDescription());
    }
}
