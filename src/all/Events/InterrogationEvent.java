package all.Events;

import all.Enums.PolicemanRanks;
import all.Exceptions.InterrogationExplanationException;
import all.misc.NamePrinter;
import all.People.Person;
import all.People.Policeman;

import java.net.URISyntaxException;
import java.util.Random;

public class InterrogationEvent extends Event {

    private final Policeman[] policemans;
    private final Person suspect;
    private final String suspected_in;
    private final String imprisoning_reason;

    public InterrogationEvent(Person suspect, String suspected_in, String imprisoning_reason, Policeman... police_officer) {
        super("Допрос");
        this.policemans = police_officer;
        this.suspect = suspect;
        this.suspected_in = suspected_in;
        this.imprisoning_reason = imprisoning_reason;
    }

    public void start() {
        String names = new NamePrinter().getPersons(policemans);

        String ending;
        if (policemans.length > 1) {
            ending = "ют";
        } else {
            ending = "ет";
        }

        System.out.printf("%sподозрева%s %s в %s%n", names, ending, suspect, suspected_in);

        try {
            Random random = new Random();
            float a = random.nextFloat();
            if (a > 0.5) {
                System.out.printf("%s объяснил, где он был%n", suspect);
            } else {
                throw new InterrogationExplanationException();
            }
        } catch (InterrogationExplanationException | URISyntaxException e) {
            for (Policeman policeman : policemans) {
                if (policeman.getRank() == PolicemanRanks.Commissioner) {
                    System.out.printf("%s посадил %s в кутузку за %s%n", policeman.getName(), suspect.getName(), imprisoning_reason);
                }
            }
        }
    }
}
