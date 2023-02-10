package org.example.hometask.managers;


import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import org.example.hometask.requests.RequestHandler;

import java.util.List;

@SuperBuilder
@NoArgsConstructor
public abstract class Manager implements RequestHandler {
    List<Manager> managers;
}
