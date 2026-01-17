package entities;

import annotations.Invoke;

public class InvokeDemo {

    private boolean invoked;

    @Invoke
    public String sayHello() {
        invoked = true;
        return "Hello from @Invoke method";
    }

    public String skipMe() {
        return "Not annotated";
    }

    public boolean wasInvoked() {
        return invoked;
    }
}
