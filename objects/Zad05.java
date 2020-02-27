import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Zad05 {

    static class Student {
        private String firstName;
        private String secondName;
        private double grade;

        public static Student parseStudent(String input) {
            String[] args = input.split(" ");
            return new Student(args[0], args[1], Double.parseDouble(args[2]));
        }

        public Student(String firstName, String secondName, double grade) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", this.getFirstName(), this.getSecondName(), this.getGrade());
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public double getGrade() {
            return grade;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++) {
            String input = sc.nextLine();
            students.add(Student.parseStudent(input));
        }
        students.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).forEach(System.out::println);
    }
}
