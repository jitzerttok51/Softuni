import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Zad04 {

    static class Article {
        private String title, content, author;

        public Article(String title, String content, String author) {
            this.setTitle(title);
            this.setContent(content);
            this.setAuthor(author);
        }

        public void edit(String newContent) {
            this.setContent(newContent);
        }

        public void chaneAuthor(String newAuthor) {
            this.setAuthor(newAuthor);
        }

        public void rename(String newName) {
            this.setTitle(newName);
        }

        @Override
        public String toString() {
            return String.format(
                    "%s - %s: %s",
                    this.getTitle(),
                    this.getContent(),
                    this.getAuthor());
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        static Article createArticleFormString(String input) {
            String[] args = input.split(", ");
            return new Article(
                    args[0].trim(),
                    args[1].trim(),
                    args[2].trim()
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Article> articles = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++) {
            String input = sc.nextLine();
            articles.add(Article.createArticleFormString(input));
        }
        String criteria = sc.nextLine();
        switch (criteria) {
            case "title":
                articles.stream().sorted(Comparator.comparing(Article::getTitle)).forEach(System.out::println);
                break;
            case "content":
                articles.stream().sorted(Comparator.comparing(Article::getContent)).forEach(System.out::println);
                break;
            case "author":
                articles.stream().sorted(Comparator.comparing(Article::getAuthor)).forEach(System.out::println);
                break;
        }
    }
}
