import java.util.Scanner;

public class StudentMarksStatistics {

    final private Scanner scanner;
    private String assignmentName;
    final private double[] marks;
    final private int totalStudents;

    /**
     * Set assignment name
     * @param name - Assignment name
     */
    private void setAssignmentName(String name) {
        assignmentName = name;
    }

    /**
     * Get assignment name
     * @return assignment name
     */
    private String getAssignmentName() {
        return assignmentName;
    }

    StudentMarksStatistics(int students) {
        totalStudents = students;

        scanner = new Scanner(System.in);
        marks = new double[totalStudents];
    }

    /**
     * Calculate Marks Statistics (highest, lowest, mean and standard deviation)
     */
    public void calculateMarksStatistics() {

        // F1: Input Assignment name
        System.out.print("Enter the assignment name:- ");
        String input = scanner.nextLine();
        setAssignmentName(input);

        // F2: Allow input student's mark
        for (int i = 1; i <= totalStudents; i++) {
            System.out.print("Enter marks for student " + i + ":- ");
            double mark = validateMarks(i);
            marks[i - 1] = mark;
        }

        scanner.close();

        printAssignmentNameAndMarks();
        printHighestAndLowestMarks();
    }


    /**
     * F3: Check and show error if invalid mark is input
     * @return mark of each student
     */
    public double validateMarks(int index) {
        while (true) {
            String input = scanner.nextLine();
            try {
                double mark = Double.parseDouble(input);

                if (mark >= 0 && mark <= 30) {
                    return mark;
                } else {
                    System.out.print("Please enter valid mark between 0 and 30 for student " + index + ":- ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid mark between 0 and 30 for student " + index + ":- ");
            }
        }
    }

    /**
     * F4: Print Assignment name and Marks
     */
    public void printAssignmentNameAndMarks() {

        System.out.println("Assignment Name:- " + getAssignmentName());

        for (int i = 0; i < totalStudents; i++) {
            System.out.println("Marks of Student " + (i + 1) + " = " + marks[i]);
        }
    }

    /**
     * F5: Print Assignment name and Marks
     */
    public void printHighestAndLowestMarks() {

        double highestMark  = marks[0];
        double lowestMark = marks[0];

        for (int i = 0; i < totalStudents; i++) {
            if (highestMark < marks[i]) {
                highestMark = marks[i];
            }

            if (lowestMark > marks[i]) {
                lowestMark = marks[i];
            }
        }

        System.out.println("Highest mark is = " + highestMark);

        System.out.println("Lowest mark is = " + lowestMark);
    }
}
