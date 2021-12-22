package all;

import all.Events.Eventable;
import all.Exceptions.NotInArrayListException;

import java.util.ArrayList;
import java.util.Arrays;

public class Day {

    private final ArrayList<Eventable> day_events;

    public Day(ArrayList<Eventable> day_events) {
        this.day_events = day_events;
    }

    public void start() {
        System.out.println("Hear me, Hear me! The work shift starts!");

        System.out.println();
        System.out.println();

        for (Eventable day_event : this.day_events) {
            day_event.start();
            System.out.println();
            System.out.println();
        }


        System.out.println("End of shift. Go rest all who can!");
    }

    public void add_event(Eventable event) {
        this.day_events.add(event);
    }

    public void add_event(Eventable... events) {
        this.day_events.addAll(Arrays.asList(events));
    }

    public void delete_event(Eventable event) throws NotInArrayListException {
        if (this.day_events.contains(event)) {
            this.day_events.remove(event);
        }
        else {
            throw new NotInArrayListException();
        }
    }

    @Override
    public String toString() {
        return String.format("День с %s событий", this.day_events.size());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Day) {
            return this.day_events.size() == ((Day) obj).day_events.size();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.day_events.size()*456;
    }
}
