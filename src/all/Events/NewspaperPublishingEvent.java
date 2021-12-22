package all.Events;

import all.Things.Newspaper;
import all.People.Person;

public class NewspaperPublishingEvent extends Event {
    private final Person publisher;
    private final Newspaper newspaper;

    public NewspaperPublishingEvent(Person publisher, Newspaper newspaper) {
        super("печать статьи");
        this.newspaper = newspaper;
        this.publisher = publisher;
    }

    public void start() {
        System.out.println(publisher.getName() + " напечатал в газете следующее:");
        newspaper.publicArticles();
    }
}
