import java.util.Scanner;

public class Zad02 {

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
    }

    static Article createArticleFormString(String input) {
        String[] args = input.split(", ");
        return new Article(
                args[0].trim(),
                args[1].trim(),
                args[2].trim()
                );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Article article = createArticleFormString(input);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++) {
            input = sc.nextLine();
            String[] tokens = input.split(": ");
            switch (tokens[0]) {
                case "Edit": article.edit(tokens[1]); break;
                case "ChangeAuthor": article.chaneAuthor(tokens[1]); break;
                case "Rename": article.rename(tokens[1]); break;
            }
        }
        System.out.println(article);
    }
}
