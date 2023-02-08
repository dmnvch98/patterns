package org.example.hometask;

public class Main {
    public static void main(String[] args) {
        Founder founder = Founder.builder().build();
        founder.sendCommand(
            Request
                .builder()
                .command(() -> System.out.println("some req"))
                .requestType(RequestType.EMPLOYEE_REQUEST)
                .build()
        );
    }
}
