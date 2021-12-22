package all.Events;

import all.Things.Business;
import all.Things.Market;

public class MarketEvent extends Event{
    private final Business[] businesses;
    private final Business business_to_grow;

    public MarketEvent(Market market, Business business_to_grow, Business... businesses) {
        super("Рыночек порешал");
        this.business_to_grow = business_to_grow;
        this.businesses = businesses;
    }

    public void start() {
        business_to_grow.grow();
    }
}
