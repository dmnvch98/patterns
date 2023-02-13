package org.example.patternshometask.executors;

import lombok.experimental.SuperBuilder;
import org.example.patternshometask.requests.Request;

@SuperBuilder
public class SupplierAdapter extends Executor {
    Supplier supplier;

    @Override
    public boolean canHandleRequest(Request req) {
        return supplier.canExecuteTask(req);
    }

    @Override
    public Request handle(Request req) {
        return supplier.execute(req);
    }
}
