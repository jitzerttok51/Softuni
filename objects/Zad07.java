import java.util.*;

public class Zad07 {
    static class Person {
        private String name;
        private String id;
        private int age;

        public static Person parsePerson(String input) {
            String[] args = input.split("\\s+");
            return new Person(args[0], args[1], Integer.parseInt(args[2]));
        }

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.",
                    this.getName(), this.getId(), this.getAge());
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (!"End".equals(line)) {
            people.add(Person.parsePerson(line));
            line = sc.nextLine();
        }
        people
                .stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);
    }
}
