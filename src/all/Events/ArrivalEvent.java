package all.Events;

import all.misc.NamePrinter;
import all.People.Person;

public class ArrivalEvent extends Event {

    Person[] arrivals;
    String where_from;
    String where_to;


    public ArrivalEvent(String where_from, String where_to, Person... arrivals) {
        super("Прибытие");
        this.arrivals = arrivals;
        this.where_from = where_from;
        this.where_to = where_to;

    }

    public void start() {
        String names = new NamePrinter().getPersons(arrivals);
        System.out.printf("%sприбыли из %s в %s%n", names, where_from, where_to);
    }
}
