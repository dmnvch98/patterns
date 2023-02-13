package org.example.patternshometask.executors.states;

import lombok.Builder;

@Builder
public class SickState implements State {
    @Override
    public String observe() {
        return "sick";
    }
}
