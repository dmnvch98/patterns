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

public class Administrator {
    List<Executor> executors;

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

    public void makeRequest(Request req) {
        executors
            .stream()
            .filter(handler -> handler.canHandleRequest(req))
            .findFirst()
            .ifPresent(handler -> handler.handle(req));
    }

    @Builder
    public Administrator() {
        buildChain();
    }
}
