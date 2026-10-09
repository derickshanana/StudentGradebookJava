/**
 * Abstract base class representing a person.
 * It holds the fields shared by every kind of person (name and ID) and
 * declares an abstract method that every subclass MUST implement.
 * This demonstrates the "abstract" keyword.
 */
public abstract class Person {
    // Variables: shared data for every person
    private String name;
    private int id;

    /**
     * Creates a person with a name and an ID.
     */
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /** Returns the person's name. */
    public String getName() {
        return name;
    }

    /** Returns the person's ID number. */
    public int getId() {
        return id;
    }

    /**
     * Abstract method: each subclass decides how to describe itself.
     * There is no body here because Person is only a template.
     */
    public abstract String displayInfo();
}
