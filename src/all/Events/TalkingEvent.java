package all.Events;

import all.People.Human;

public class TalkingEvent extends Event {

    private final Human speaker;
    private final String phrase;

    public TalkingEvent(Human speaker, String phrase) {
        super(String.format("%s говорит", speaker.getName()));
        this.speaker = speaker;
        this.phrase = phrase;
    }

    public void start()
    {
        this.speaker.talk(this.phrase);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof TalkingEvent) {
            return this.speaker.getName().equals(((TalkingEvent) obj).getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.speaker.getName();
    }

    @Override
    public int hashCode() {
        return this.speaker.getName().hashCode();
    }
}
