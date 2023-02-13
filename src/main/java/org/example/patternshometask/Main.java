package org.example.patternshometask;

import org.example.patternshometask.hierarchy.HardHierarchy;
import org.example.patternshometask.hierarchy.MiddleHierarchy;
import org.example.patternshometask.hierarchy.SimpleHierarchy;
import org.example.patternshometask.requests.Request;
import org.example.patternshometask.requests.RequestType;

public class Main {
    public static void main(String[] args) {
        SimpleHierarchy simpleHierarchy = SimpleHierarchy.builder()
            .build();
        simpleHierarchy.sendRequest(
            Request
                .builder()
                .command(() -> System.out.println("simple req"))
                .requestType(RequestType.SUPPLIER_REQUEST)
                .build()
        );

        MiddleHierarchy middleHierarchy = MiddleHierarchy.builder().build();
        middleHierarchy.sendRequest(
            Request
                .builder()
                .command(() -> System.out.println("middle req"))
                .requestType(RequestType.SUPPLIER_REQUEST)
                .build()
        );

        HardHierarchy hardHierarchy = HardHierarchy.builder().build();
        hardHierarchy.sendRequest(
            Request
                .builder()
                .command(() -> System.out.println("hard req"))
                .requestType(RequestType.SUPPLIER_REQUEST)
                .build()
        );
    }
}
