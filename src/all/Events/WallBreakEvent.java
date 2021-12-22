package all.Events;

import all.Enums.HouseParts;
import all.People.Human;

public class WallBreakEvent extends Event {

    private final Human house_owner;
    private final Event break_event;
    private final HouseParts part;


    public WallBreakEvent(HouseParts part, Human house_owner, Event break_event) {
        super("Разрушение стены");
        this.part = part;
        this.house_owner = house_owner;
        this.break_event = break_event;
    }

    public void start() {
        System.out.printf("Стена %s в доме владельца %s разрушилась в результате события %s%n", part, this.house_owner.getName(), this.break_event.getName());
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof SuitcaseExcavationEvent) {
            return this.house_owner.getName().equals(((SuitcaseExcavationEvent) obj).getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.house_owner.getName();
    }

    @Override
    public int hashCode() {
        return this.house_owner.getName().hashCode();
    }
}
