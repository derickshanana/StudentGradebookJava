import java.util.ArrayList;

/**
 * Manages the collection of students.
 * Uses an ArrayList<Student> from the Java Collection Framework.
 */
public class Gradebook {
    private ArrayList<Student> students;

    /** Creates an empty gradebook. */
    public Gradebook() {
        this.students = new ArrayList<>();
    }

    /**
     * Adds a new student if the ID is not already used.
     * Returns true if the student was added.
     */
    public boolean addStudent(String name, int id) {
        // Conditional: IDs must be unique
        if (findStudent(id) != null) {
            return false;
        }
        students.add(new Student(name, id));
        return true;
    }

    /**
     * Removes the student with the given ID.
     * Returns true if a student was removed.
     */
    public boolean removeStudent(int id) {
        Student found = findStudent(id);
        if (found == null) {
            return false;
        }
        students.remove(found);
        return true;
    }

    /**
     * Searches for a student by ID.
     * Returns the Student, or null if not found.
     */
    public Student findStudent(int id) {
        // Loop: check each student in the list
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    /**
     * Adds a grade to the student with the given ID.
     * Returns true if the student exists and the grade was valid.
     */
    public boolean addGradeToStudent(int id, double grade) {
        Student found = findStudent(id);
        if (found == null) {
            return false;
        }
        return found.addGrade(grade);
    }

    /**
     * Calculates the average of every student's average (class average).
     * Only students with at least one grade are counted.
     */
    public double calculateClassAverage() {
        double sum = 0.0;
        int counted = 0;
        for (Student student : students) {
            if (student.getGradeCount() > 0) {
                sum += student.calculateAverage();
                counted++;
            }
        }
        // Expression with a guard against dividing by zero
        return counted == 0 ? 0.0 : sum / counted;
    }

    /** Prints every student in the gradebook. */
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("The gradebook is empty.");
            return;
        }
        System.out.println("\n--- Gradebook ---");
        for (Student student : students) {
            // Polymorphism: displayInfo() comes from the Person contract
            System.out.println(student.displayInfo());
        }
        System.out.printf("Class average: %.2f%n", calculateClassAverage());
    }
}
