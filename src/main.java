import all.Day;
import all.Enums.HouseParts;
import all.Events.*;
import all.Things.Business;
import all.Things.Market;
import all.Things.Newspaper;
import all.People.*;

import java.util.ArrayList;

import static all.Enums.PolicemanRanks.Commissioner;
import static all.Enums.PolicemanRanks.CommissionerAssistant;

class Main {
    public static void main(String[] args) {
        ArrayList<Eventable> events = new ArrayList<>();

        Person sus1 = new Person("Лысый коротышка", "Ул. Пушкина, д. Колотушкина");
        Person sus2 = new Person("Лысый коротышка 2", "Ул. Пушкина, д. Колотушкина");
        Person sus3 = new Person("Лысый коротышка 3", "Ул. Пушкина, д. Колотушкина");
        ArrivalEvent arrivalEvent = new ArrivalEvent("Город", "полицейский участок", sus1, sus2, sus3);
        events.add(arrivalEvent);

        Policeman pshigl = new Policeman("Пшигль", "Полицейское управление", Commissioner);
        Policeman digl = new Policeman("Дигль", "Полицейское управление", CommissionerAssistant);
        Policeman gigl = new Policeman("Гигль", "Полицейское управление", CommissionerAssistant);
        Policeman spigl = new Policeman("Спигль", "Полицейское управление", CommissionerAssistant);
        Policeman psigl = new Policeman("Псигль", "Полицейское управление", CommissionerAssistant);


        for (Person sus : new Person[]{sus1, sus2, sus3}) {
            InterrogationEvent interrogation = new InterrogationEvent(sus, "написании оскорбительного письма", "ограбление банка", pshigl, digl, gigl, spigl, psigl);
            events.add(interrogation);
        }

        Person kuks = new Person("Кукс", "Улица Пушкина, д. Колотушкина");
        Person kaktus = new Person("Кактус", "Кривая улица, д. 47");
        Person judge = new Person("Фольтест", "Темерия, замок Ла Валетт");

        events.add(new TalkingEvent(kuks, "Поднимаю цену на аренду моего дома, Кактус"));
        events.add(new TalkingEvent(kaktus, "Где-то во дворе дома товарища Кукса зарыт чемоданчик с золотом! Нужно больше золота!"));

        SuitcaseExcavationEvent excavation = new SuitcaseExcavationEvent(kaktus);
        events.add(excavation);
        events.add(new WallBreakEvent(HouseParts.SOUTH_WALL, kuks, excavation));

        JudicialProcessEvent first_process = new JudicialProcessEvent("Первый судебный",
                new Defendant(kaktus, "Не было такого. И вообще он цену на жильё необоснованно завысил!"), new Judge(judge), new Plaintiff(kuks, "Она придумала чемоданчик с золотом в отместку за повышение цены на аренду, чтобы из-за раскопок сломалась стена!"));

        events.add(first_process);

        Person editor = new Person("Редактор", "Газетное агентство");
        Newspaper newspaper = new Newspaper();
        String article_text =
                "Господа давилонцы, " +
                        "самое время портить " +
                        "покрышки друг другу (и не только).";
        newspaper.addArticle("Коротышка Брехсон", article_text);

        NewspaperPublishingEvent publishingEvent = new NewspaperPublishingEvent(editor, newspaper);
        events.add(publishingEvent);


        Person pudd = new Person("Пудд", "Склад покрышек");
        Person dudd = new Person("Дудд", "Склад бензина");
        Person kudd = new Person("Кудд", "Склад бензина");
        Person fudd = new Person("Будд", "Магазин бензина");
        Market market = new Market();
        Business tires_market = new Business("Магазин покрышек", pudd, market) {
            @Override
            public String toString() {

                return this.getName() + ", владелец которого действительно виноват в чём-то,";
            }
        };
        Business gasoline_business = new Business("Бизнесс бензина", dudd, market);
        Business gasoline_warehouse = new Business("Склад бензина", kudd, market);
        Business gasoline_market = new Business("Магазин бензина", fudd, market);

        market.addBusiness(tires_market, gasoline_business, gasoline_warehouse, gasoline_market);

        MarketEvent marketEvent = new MarketEvent(market, tires_market, tires_market, gasoline_business, gasoline_warehouse, gasoline_market);
        events.add(marketEvent);

        JudicialProcessEvent second_process = new JudicialProcessEvent(
                "Второй судебный",
                new Defendant(editor, "Я напечатал в газате письмо"),
                new Judge(judge),
                new Plaintiff(kaktus, "Он напечатал письмо, не относящееся ко мне!"));
        events.add(second_process);

        JudicialProcessEvent third_process = new JudicialProcessEvent(
                "Третий судебный",
                new Defendant(pudd, "Я не печатал то письмо"),
                new Judge(judge),
                new Plaintiff(kudd, "Пудд напечатал письмо, из-за которого у него увеличились продажи, а у нас упали"),
                new Plaintiff(fudd, "Пудд напечатал письмо, из-за которого у него увеличились продажи, а у нас упали"),
                new Plaintiff(dudd, "Пудд напечатал письмо, из-за которого у него увеличились продажи, а у нас упали")
        );

        events.add(third_process);

        Day day = new Day(events);
        day.start();
    }
}

// 312522