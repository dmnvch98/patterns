package org.example.hometask.hierarchy;

public class MiddleHierarchy {
    public MiddleHierarchy() {
        SimpleHierarchy simpleHierarchy = SimpleHierarchy.builder().build();
        simpleHierarchy.getFounder().getDirector()
    }
}
