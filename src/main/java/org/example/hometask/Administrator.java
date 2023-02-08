package org.example.hometask;

import lombok.Builder;
import org.example.hometask.executors.Employee;
import org.example.hometask.executors.Executor;
import org.example.hometask.executors.Supplier;
import org.example.hometask.executors.states.DayOfState;
import org.example.hometask.executors.states.SickState;
import org.example.hometask.executors.states.VacationState;
import org.example.hometask.executors.states.WorkState;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Administrator implements RequestHandler {
    private List<Executor> executors;
    private final String name;
    private Optional<Executor> canHandleRequestExecutor;

    private void buildChain() {
        executors = Arrays.asList(
            Employee.builder().state(DayOfState.builder().build()).name("1").build(),
            Employee.builder().state(SickState.builder().build()).name("2").build(),
            Employee.builder().state(WorkState.builder().build()).name("3").build(),
            Employee.builder().state(VacationState.builder().build()).name("4").build(),

            Supplier.builder().state(DayOfState.builder().build()).name("1").build(),
            Supplier.builder().state(VacationState.builder().build()).name("2").build(),
            Supplier.builder().state(SickState.builder().build()).name("3").build(),
            Supplier.builder().state(WorkState.builder().build()).name("4").build()
        );
    }

    @Builder
    public Administrator(String name) {
        this.name = name;
        buildChain();
    }

    @Override
    public boolean canHandleRequest(Request req) {
        canHandleRequestExecutor = executors.stream()
            .filter(executor -> executor.canHandleRequest(req))
            .findFirst();
        if (canHandleRequestExecutor.isPresent()) {
            System.out.println("Admin " + name + " found executor who can execute task :)");
            return true;
        }
        System.out.println("Admin " + name + " didn't find executor who can execute task :(");
        return false;
    }

    @Override
    public Request handle(Request req) {
        if (canHandleRequestExecutor.isPresent()) {
            return canHandleRequestExecutor.get().handle(req);
        }
        return req;
    }
}
