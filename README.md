# Overview

As a software engineer, I want to be comfortable with Java because it is one of the most widely used languages for business software, backend services, and Android development. Learning how Java organizes code into classes, how it handles inheritance, and how its Collection Framework stores data gives me a strong foundation for building larger, more maintainable programs.

To practice these ideas, I wrote a command-line Student Gradebook. The program lets a user add students, record grades for each student, remove students, look up a single student, and view the whole gradebook. For each student it calculates an average and converts it into a letter grade, and it also calculates the class average. Students are stored in an `ArrayList<Student>`, and each student keeps an `ArrayList<Double>` of grades. The program uses an abstract `Person` class that holds a name and ID, and a `Student` class that `extends` it and implements the abstract `displayInfo()` method.

My purpose in writing this software was to practice the core Java building blocks (variables, expressions, conditionals, loops, methods, and classes) while focusing on inheritance with the `extends` and `abstract` keywords.

[Software Demo Video](https://www.youtube.com/watch?v=VYwa1ig4_nw)

# Development Environment

I used Visual Studio Code to write the code and the integrated terminal to compile and run it with the Java Development Kit (JDK). The program is compiled with `javac` and run with `java`.

The program is written in Java and uses only the standard library: `java.util.ArrayList` for storing students and grades, and `java.util.Scanner` for reading user input. No third-party libraries were used.

# How to Run

1. Install a JDK and make sure `javac` and `java` are on your PATH.
2. From the project folder, compile: `javac *.java`
3. Run: `java Main`

# Useful Websites

- [Java Platform, Standard Edition Documentation](https://docs.oracle.com/en/java/javase/index.html)
- [Oracle Java Tutorials: Abstract Methods and Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Wikipedia: Java (programming language)](https://en.wikipedia.org/wiki/Java_(programming_language))

# Future Work

- Save the gradebook to a file so students and grades persist between runs.
- Allow grades to be grouped by course or assignment name.
- Add the ability to edit or delete an individual grade.
- Sort the gradebook display by name or by average.
