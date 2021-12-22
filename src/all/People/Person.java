package all.People;
public class Person implements Human {

    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void talk(String phrase) {
        System.out.printf("%s: %s%n", this.name, phrase);
    }

    @Override
    public void walk(float distance) {
        System.out.printf("%s прошёл %s метров%n", this.name, distance);
    }

    @Override
    public void sleep(float time) {
        System.out.printf("%s проспал %s часов%n", this.name, time);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() { return this.address; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Person) {
            return this.name.equals(((Person) obj).getName());
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
