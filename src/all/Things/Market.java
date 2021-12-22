package all.Things;

import java.util.ArrayList;
import java.util.Arrays;

public class Market extends Thing{

    ArrayList<Business> business_array;

    public Market() {
        super("Доля рынка");
        business_array = new ArrayList<Business>();
    }

    public void addBusiness(Business... business) {
        business_array.addAll(Arrays.asList(business));
    }

    public void removeBusiness(Business business) {
        business_array.remove(business);
    }

    public void changeMarketSituation(Business changed_business) {
        if (business_array.contains(changed_business)) {
            for (Business business : business_array) {
                if (!business.equals(changed_business)) {
                    System.out.printf("Доля бизнеса %s уменьшилась%n", business);
                } else {
                    System.out.printf("Доля бизнеса %s увеличилась%n", changed_business);
                }
            }
        }
    }
}

