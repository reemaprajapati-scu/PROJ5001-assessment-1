public class Main {
    public static void main(String[] args) {

        final int totalStudents = 30;

        StudentMarksStatistics studentMarksStatistics = new StudentMarksStatistics(totalStudents);
        studentMarksStatistics.calculateMarksStatistics();
    }
}