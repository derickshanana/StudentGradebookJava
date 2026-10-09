import java.util.ArrayList;

/**
 * A student in the gradebook.
 * Student EXTENDS the abstract Person class, so it inherits name and ID,
 * and it adds a list of grades plus grade-related calculations.
 */
public class Student extends Person {
    // Collection Framework requirement: an ArrayList of grades
    private ArrayList<Double> grades;

    /**
     * Creates a student with no grades yet.
     */
    public Student(String name, int id) {
        super(name, id); // call the Person constructor
        this.grades = new ArrayList<>();
    }

    /**
     * Adds a grade (0-100) to this student's list.
     * Returns true if the grade was valid and added.
     */
    public boolean addGrade(double grade) {
        // Conditional: reject grades outside the valid range
        if (grade < 0 || grade > 100) {
            return false;
        }
        grades.add(grade);
        return true;
    }

    /** Returns how many grades this student has. */
    public int getGradeCount() {
        return grades.size();
    }

    /**
     * Calculates the average of all grades.
     * Returns 0 if the student has no grades yet.
     */
    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        // Loop: add up every grade in the list
        for (double grade : grades) {
            sum += grade;
        }
        // Expression: sum divided by count gives the average
        return sum / grades.size();
    }

    /**
     * Converts the numeric average into a letter grade.
     */
    public String getLetterGrade() {
        double average = calculateAverage();
        // Conditionals: if/else chain maps a score range to a letter
        if (grades.isEmpty()) {
            return "N/A";
        } else if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * Implements the abstract method from Person.
     * Builds a one-line summary of the student.
     */
    @Override
    public String displayInfo() {
        return String.format("ID %d | %s | Grades: %d | Average: %.2f | Letter: %s",
                getId(), getName(), getGradeCount(), calculateAverage(), getLetterGrade());
    }
}
