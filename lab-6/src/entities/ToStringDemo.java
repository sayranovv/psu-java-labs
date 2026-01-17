package entities;

import annotations.ToString;

@ToString
public class ToStringDemo {

    @ToString
    private String title = "Included";

    @ToString(ToString.Mode.NO)
    private String secret = "Hidden";

    private int number = 42;

    public String getTitle() {
        return title;
    }

    public String getSecret() {
        return secret;
    }

    public int getNumber() {
        return number;
    }
}
