package all.People;

import java.util.Random;

public class Judge extends Person implements JudgeInterface {

    private final String person_name;

    public Judge(Person person) {
        super(person.getName(), person.getAddress());
        this.person_name = person.getName();
    }

    @Override
    public Person makeDecision(Person plaintiff, Person defendant) {

        Random random = new Random();
        random.setSeed(4);

        if (random.nextFloat() > 0.5) {
            super.talk(String.format("Я принял решение в пользу %s", plaintiff.getName()));
            return plaintiff;
        }

        super.talk(String.format("Я принял решение в пользу %s", defendant.getName()));
        return defendant;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Judge) {
            return this.person_name.equals(((Judge) obj).getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.person_name;
    }

    @Override
    public int hashCode() {
        return this.person_name.hashCode();
    }
}
