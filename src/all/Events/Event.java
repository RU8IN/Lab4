package all.Events;

public abstract class Event implements Eventable {

    private final String name;

    public Event(String name) { this.name = name; }

    @Override
    public String getName() { return this.name; }

}