package all.Things;

public abstract class Thing implements ThingInterface {

    protected final String name;

    public Thing(String name) {
        this.name = name;
    }

    @Override
    public void spawn() {
        System.out.printf("Предмет \"%s\" создан%n", this.name);
    }

    @Override
    public void action(String name) {
        System.out.printf("%s существует%n", this.name);
    }

    @Override
    public String getName() { return this.name; }
}
