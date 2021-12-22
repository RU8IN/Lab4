package all.Events;

import all.People.Defendant;
import all.People.Judge;
import all.People.Person;
import all.People.Plaintiff;

public class JudicialProcessEvent extends Event {

    private final String process_name;
    private final Plaintiff[] plaintiff_array;
    private final Defendant defendant;
    private final Judge judge;

    public JudicialProcessEvent(String process_name, Defendant defendant, Judge judge, Plaintiff... plaintiff) {
        super(process_name);
        this.plaintiff_array = plaintiff;
        this.defendant = defendant;
        this.judge = judge;
        this.process_name = process_name;
    }

    public void start() {
        System.out.printf("%s начался%n", process_name);
        for (Plaintiff plaintiff : plaintiff_array) {
            plaintiff.say_lawsuit();
        }
        this.defendant.sayDefendPhrase();
        Person winner = this.judge.makeDecision(plaintiff_array[0], this.defendant);
        System.out.printf("Победил %s%n", winner.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof JudicialProcessEvent) {
            return this.process_name.equals(((JudicialProcessEvent) obj).getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.process_name;
    }

    @Override
    public int hashCode() {
        return this.process_name.hashCode();
    }
}
