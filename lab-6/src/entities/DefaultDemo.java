package entities;

import annotations.Default;

@Default(String.class)
public class DefaultDemo {
    private String value = "demo";

    public String getValue() {
        return value;
    }
}
