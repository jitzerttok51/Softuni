import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Zad03 {

    static class Person {

        private String name;
        private int age;

        static Person createPerson(String raw) {
            String[] args = raw.split(" ");
            return new Person(args[0], Integer.parseInt(args[1]));
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return this.getName() + " - " + this.getAge();
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            people.add(Person.createPerson(line));
        }

        people
                .stream()
                .filter(p->p.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
