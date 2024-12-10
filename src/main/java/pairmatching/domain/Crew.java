package pairmatching.domain;

public class Crew {

    private final String name;

    public Crew(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "name='" + name + '\'' +
                '}';
    }
}
