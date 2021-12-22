package all.misc;

import all.People.Person;

public class NamePrinter {

    Person[] persons;

    public String getPersons(Person... persons) {
        String names = "";

        for (int i = 0; i < persons.length; i++) {
            if (i != persons.length - 1) {
                names = names + persons[i] + ", ";
            } else {
                names = names + persons[i] + " ";
            }
        }

        return names;
    }
}
