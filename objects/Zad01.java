import java.util.Random;
import java.util.Scanner;

public class Zad01 {

    /*
    * •	Phrases – {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."}
    •	Events – {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"}
    •	Authors – {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"}
    •	Cities – {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"}
    * */

    private static final String[] PHRASES = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
    private static final String[] EVENTS = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
    private static final String[] AUTHORS = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
    private static final String[] CITIES = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

    static class Message {
        private String phase, event, author, city;

        public Message() {
            this(
                    randomString(PHRASES),
                    randomString(EVENTS),
                    randomString(AUTHORS),
                    randomString(CITIES)
            );
        }

        private static Random random;
        private static int randomIndex(int length) {
            if(random==null) {
                random = new Random();
            }

            return random.nextInt(length);
        }
        private static String randomString(String[] arr) {
            return arr[randomIndex(arr.length)];
        }

        public Message(String phase, String event, String author, String city) {
            this.phase = phase;
            this.event = event;
            this.author = author;
            this.city = city;
        }

        public String getPhase() {
            return phase;
        }

        public String getEvent() {
            return event;
        }

        public String getAuthor() {
            return author;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return String.format(
                    "%s %s %s – %s",
                    this.getPhase(),
                    this.getEvent(),
                    this.getAuthor(),
                    this.getCity()
                    );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n; i++) {
            System.out.println(new Message());
        }
    }
}
