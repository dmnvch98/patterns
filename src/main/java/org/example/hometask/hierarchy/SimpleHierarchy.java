package org.example.hometask.hierarchy;

import lombok.Builder;
import lombok.Value;
import org.example.hometask.Tax;
import org.example.hometask.executors.Employee;
import org.example.hometask.executors.Supplier;
import org.example.hometask.executors.SupplierAdapter;
import org.example.hometask.executors.states.DayOfState;
import org.example.hometask.executors.states.SickState;
import org.example.hometask.executors.states.VacationState;
import org.example.hometask.executors.states.WorkState;
import org.example.hometask.managers.Administrator;
import org.example.hometask.managers.Director;
import org.example.hometask.managers.Founder;
import org.example.hometask.requests.Request;

import java.util.Arrays;
import java.util.Collections;

@Value
public class SimpleHierarchy {
    Founder founder;

    @Builder
    public SimpleHierarchy() {
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

        Tax tax = Tax.builder().build();

        Director director = Director
            .builder()
            .deputyDirectors(Arrays.asList(administrator1, administrator2))
            .requestObservers(Collections.singletonList(tax))
            .build();
        this.founder = Founder.builder().director(director).build();
    }

    public void sendRequest(Request request) {
        founder.sendRequest(request);
    }
}
