import java.util.Scanner;

public class StudentMarksStatistics {

    final private Scanner scanner;
    private String assignmentName;
    private int[] marks;
    private int totalStudents;

    StudentMarksStatistics() {
        scanner = new Scanner(System.in);
    }

    public void calculateMarksStatistics() {

        assignmentName = getAssignmentName();

        totalStudents = getTotalStudents();

        marks = new int[totalStudents];

        // F2: Allow input student's mark
        for (int i = 1; i <= totalStudents; i++) {
            System.out.print("Enter marks for student " + i + ":- ");
            int mark = validateMarks(i);
            marks[i - 1] = mark;
        }

    }

    /**
     * F1: Input Assignment name
     * @return Assignment name
     */
    private String getAssignmentName() {
        System.out.print("Enter the assignment name:- ");
        return scanner.nextLine();
    }

    /**
     * Get total number of students
     * @return Total number of students
     */
    private int getTotalStudents() {
        System.out.print("Input total students in the unit:- ");
        while (true) {
            String input = scanner.nextLine();

            try {
                totalStudents = Integer.parseInt(input);

                if (totalStudents > 0) {
                    break;
                } else {
                    System.out.println("Please enter valid number of students in the unit:- ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid number of students the unit:- ");
            }
        }
        return totalStudents;
    }

    /**
     * F3: Check and show error if invalid mark is input
     * @return mark of each student
     */
    public int validateMarks(int index) {
        while (true) {
            String input = scanner.nextLine();
            try {
                int mark = Integer.parseInt(input);
                if (mark >= 0 && mark <= 30) {
                    return mark;
                } else {
                    System.out.print("Please enter valid marks (0-30) for student " + index + ":- ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number (0-30) for student " + index + ":- ");
            }
        }
    }

}
