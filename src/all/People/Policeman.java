package all.People;

import all.Enums.PolicemanRanks;

public class Policeman extends Person {

    private final PolicemanRanks rank;

    public Policeman(String name, String address, PolicemanRanks rank) {
        super(name, address);
        this.rank = rank;
    }

    public void interrogate(Person suspect, String suspected_in) {
        this.talk(String.format("%s, ты подозреваешься в %s%n", suspect, suspected_in));
    }

    public PolicemanRanks getRank() {
        return rank;
    }

}
