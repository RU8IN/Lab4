package all.Events;

import all.People.Human;

public class SuitcaseExcavationEvent extends Event {

    private final Human starter;

    public SuitcaseExcavationEvent(Human starter) {
        super("Раскопки чемодана с золотом");
        this.starter = starter;
    }

    public void start() {
        class Printer {
            String end_string() {
                return "Раскопки чемоданчика с золотом (минералами) инициировал: " + starter.getName() + "\n";
            }
        }
        System.out.print(new Printer().end_string());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof SuitcaseExcavationEvent) {
            return this.starter.getName().equals(((SuitcaseExcavationEvent) obj).getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.starter.getName();
    }

    @Override
    public int hashCode() {
        return this.starter.getName().hashCode();
    }
}
