package org.example.patternshometask.executors.states;

import lombok.Builder;

@Builder
public class VacationState implements State {
    @Override
    public String observe() {
        return "vacation";
    }
}