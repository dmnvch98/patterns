package org.example.hometask;

public class Main {
    public static void main(String[] args) {
        Administrator administrator = new Administrator();
        administrator.makeRequest(Request
            .builder()
            .requestType(RequestType.SUPPLIER_REQUEST)
            .description("count money")
            .build()
        );
    }
}
