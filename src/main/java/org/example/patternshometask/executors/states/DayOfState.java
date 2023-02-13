package org.example.patternshometask.executors.states;

import lombok.Builder;

@Builder
public class DayOfState implements State {
    @Override
    public String observe() {
        return "Day off";
    }
}
