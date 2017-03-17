package model;

/**
 * Abstract class to hold race attributes.
 *
 * @author Connor D. Milligan, Nathan Hall
 */
public abstract class Race {
    private String name;
    private double height;
    private double weight;

    public Race(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Race{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
