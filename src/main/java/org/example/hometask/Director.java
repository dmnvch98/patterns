package org.example.hometask;

import lombok.Builder;

import java.util.List;

@Builder
public class Director {
    List<DeputyDirector> deputyDirectors;
}
