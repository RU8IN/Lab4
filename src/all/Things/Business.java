package all.Things;


import all.People.Person;

public class Business extends Thing {

    private final Person owner;
    private final Market market;

    public Business(String name, Person owner, Market market) {
        super(name);
        this.owner = owner;
        this.market = market;
    }

    public Person getOwner() { return owner; }

    public void grow() {
        market.changeMarketSituation(this);
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
