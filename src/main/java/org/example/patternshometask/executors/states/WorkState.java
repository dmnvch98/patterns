package org.example.patternshometask.executors.states;

import lombok.Builder;

@Builder
public class WorkState implements State {
    @Override
    public String observe() {
        return "work";
    }
}
