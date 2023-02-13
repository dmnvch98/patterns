package org.example.patternshometask.hierarchy;

import lombok.Builder;
import org.example.patternshometask.Tax;
import org.example.patternshometask.executors.Employee;
import org.example.patternshometask.executors.Supplier;
import org.example.patternshometask.executors.SupplierAdapter;
import org.example.patternshometask.executors.states.DayOfState;
import org.example.patternshometask.executors.states.SickState;
import org.example.patternshometask.executors.states.VacationState;
import org.example.patternshometask.executors.states.WorkState;
import org.example.patternshometask.managers.Administrator;
import org.example.patternshometask.managers.DeputyDirector;
import org.example.patternshometask.managers.Director;
import org.example.patternshometask.managers.Founder;
import org.example.patternshometask.requests.Request;

import java.util.Arrays;
import java.util.Collections;

public class MiddleHierarchy {
    private final Founder founder;
    @Builder
    public MiddleHierarchy() {
        Administrator administrator1 = Administrator.builder().executors(Arrays.asList(
                Employee.builder().state(DayOfState.builder().build()).name("1").build(),
                Employee.builder().state(SickState.builder().build()).name("2").build(),
                Employee.builder().state(VacationState.builder().build()).name("4").build()
            ))
            .name("1")
            .build();
        administrator1.getExecutors().get(1).changeStateTo(WorkState.builder().build());

        Administrator administrator2 = Administrator.builder().executors(Arrays.asList(
                Employee.builder().state(DayOfState.builder().build()).name("1").build(),
                Employee.builder().state(SickState.builder().build()).name("2").build(),
                Employee.builder().state(WorkState.builder().build()).name("4").build(),
                SupplierAdapter.builder().supplier(
                    Supplier.builder()
                        .state(WorkState.builder().build())
                        .name("s1")
                        .build()
                ).build()
            ))
            .name("2")
            .build();

        DeputyDirectorTwo deputyDirectorTwo = DeputyDirectorTwo
            .builder()
            .managers(Arrays.asList(administrator1, administrator2))
            .build();

        DeputyDirector deputyDirector = DeputyDirector
            .builder()
            .managers(Collections.singletonList(deputyDirectorTwo))
            .build();
        Tax tax = Tax.builder().build();

        Director director = Director
            .builder()
            .managers(Collections.singletonList(deputyDirector))
            .requestObservers(Collections.singletonList(tax))
            .build();
        founder = Founder.builder().director(director).build();
    }

    public void sendRequest(Request request) {
        founder.sendRequest(request);
    }
}
