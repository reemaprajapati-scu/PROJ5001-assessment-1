import java.util.Scanner;

public class StudentMarksStatistics {

    final private Scanner scanner;
    private String assignmentName;
    final private int[] marks;
    final private int totalStudents;

    StudentMarksStatistics(int students) {
        totalStudents = students;
        marks = new int[totalStudents];
        scanner = new Scanner(System.in);
    }

    public void calculateMarksStatistics() {

        assignmentName = getAssignmentName();

        // F2: Allow input student's mark
        for (int i = 1; i <= totalStudents; i++) {
            System.out.print("Enter marks for student " + i + ":- ");
            int mark = validateMarks(i);
            marks[i - 1] = mark;
        }

        scanner.close();

        printAssignmentNameAndMarks();
        printHighestAndLowestMarks();
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
                    System.out.print("Please enter valid marks between 0 and 30 for student " + index + ":- ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number between 0 and 30 for student " + index + ":- ");
            }
        }
    }

    /**
     * F4: Print Assignment name and Marks
     */
    public void printAssignmentNameAndMarks() {
        System.out.println("Assignment Name:- " + assignmentName);

        for (int i = 0; i < totalStudents; i++) {
            System.out.println("Marks of Student " + (i + 1) + " = " + marks[i]);
        }
    }

    /**
     * F5: Print Assignment name and Marks
     */
    public void printHighestAndLowestMarks() {

    }
}
