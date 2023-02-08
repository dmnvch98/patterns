package org.example.hometask;

import org.example.hometask.executors.Employee;
import org.example.hometask.executors.states.DayOfState;
import org.example.hometask.executors.states.SickState;
import org.example.hometask.executors.states.VacationState;
import org.example.hometask.executors.states.WorkState;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Administrator administrator1 = Administrator.builder().executors(Arrays.asList(
                Employee.builder().state(DayOfState.builder().build()).name("1").build(),
                Employee.builder().state(SickState.builder().build()).name("2").build(),
                Employee.builder().state(VacationState.builder().build()).name("4").build()
            ))
            .name("1")
            .build();

        Administrator administrator2 = Administrator.builder().executors(Arrays.asList(
                Employee.builder().state(DayOfState.builder().build()).name("1").build(),
                Employee.builder().state(SickState.builder().build()).name("2").build(),
                Employee.builder().state(WorkState.builder().build()).name("4").build()
            ))
            .name("2")
            .build();

        DeputyDirector deputyDirector = DeputyDirector
            .builder()
            .allAdministrators(
                Arrays.asList(administrator1, administrator2)
            ).build();
        Director director = Director
            .builder()
            .deputyDirectors(Collections.singletonList(deputyDirector))
            .build();
        Founder founder = Founder
            .builder()
            .director(director)
            .build();

        founder.sendCommand(
            Request
                .builder()
                .command(() -> System.out.println("some req"))
                .requestType(RequestType.EMPLOYEE_REQUEST)
                .build()
        );
    }
}
