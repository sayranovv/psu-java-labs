package entities;

public class Cat implements Meowable {
    private String name;

    private int meowCount;

    public Cat(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя кота не может быть пусто");
        }
        this.meowCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public int getMeowCount() {
        return meowCount;
    }

    public void resetMeowCount() {
        this.meowCount = 0;
    }

    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
        meowCount++;
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}