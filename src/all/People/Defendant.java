package all.People;

public class Defendant extends Person implements DefendantInterface {

    private final String defend_phrase;
    private final String person_name;

    public Defendant(Person person, String defend_phrase) {
        super(person.getName(), person.getAddress());
        this.defend_phrase = defend_phrase;
        this.person_name = person.getName();
    }

    @Override
    public void sayDefendPhrase() {
        super.talk(this.defend_phrase);
    }

    @Override
    public String toString() {
        return this.defend_phrase;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Defendant) {
            return this.person_name.equals(((Defendant) obj).getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.defend_phrase.hashCode() * 256;
    }
}
