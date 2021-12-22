package all.Things;

import java.util.ArrayList;
import java.util.Date;

public class Newspaper extends Thing {

    private final ArrayList<Article> articles = new ArrayList<>();

    public Newspaper() {
        super("Газета");
    }

    static class Article {
        private final String article_text;

        public Article(String publisher, String text, Date date) {
            this.article_text = text + "\n\t" + publisher + "\n\t" + date + "\n";
        }

        @Override
        public String toString() {
            return article_text;
        }
    }

    public void addArticle(String publisher, String text) {
        Date date = new Date();
        Article article = new Article(publisher, text, date);
        articles.add(article);
    }

    public void publicArticles() {
        for (Article article: articles) {
            System.out.print("\t" + article);
        }
    }
}
