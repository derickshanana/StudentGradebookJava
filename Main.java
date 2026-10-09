import java.util.Scanner;

/**
 * Entry point for the Student Gradebook program.
 * Shows a text menu and lets the user manage students and grades.
 */
public class Main {

    /** Prints the main menu options. */
    private static void printMenu() {
        System.out.println("\n===== Student Gradebook =====");
        System.out.println("1. Add student");
        System.out.println("2. Add grade to student");
        System.out.println("3. Remove student");
        System.out.println("4. Show one student");
        System.out.println("5. Show whole gradebook");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Reads an integer from the user, asking again until the input is valid.
     */
    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    /**
     * Reads a decimal number from the user, asking again until valid.
     */
    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gradebook gradebook = new Gradebook();
        boolean running = true;

        // Loop: keep showing the menu until the user chooses to exit
        while (running) {
            printMenu();
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number from 1 to 6.");
                continue;
            }

            // Conditional: switch routes the choice to the right action
            switch (choice) {
                case 1: {
                    System.out.print("Student name: ");
                    String name = scanner.nextLine().trim();
                    int id = readInt(scanner, "Student ID: ");
                    if (gradebook.addStudent(name, id)) {
                        System.out.println("Added " + name + ".");
                    } else {
                        System.out.println("That ID is already in use.");
                    }
                    break;
                }
                case 2: {
                    int id = readInt(scanner, "Student ID: ");
                    double grade = readDouble(scanner, "Grade (0-100): ");
                    if (gradebook.addGradeToStudent(id, grade)) {
                        System.out.println("Grade recorded.");
                    } else {
                        System.out.println("Student not found or grade out of range.");
                    }
                    break;
                }
                case 3: {
                    int id = readInt(scanner, "Student ID to remove: ");
                    if (gradebook.removeStudent(id)) {
                        System.out.println("Student removed.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                }
                case 4: {
                    int id = readInt(scanner, "Student ID: ");
                    Student student = gradebook.findStudent(id);
                    if (student != null) {
                        System.out.println(student.displayInfo());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                }
                case 5:
                    gradebook.displayAll();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Choose 1-6.");
                    break;
            }
        }
        scanner.close();
    }
}
