package all.Enums;


public enum PolicemanRanks {
    Commissioner("Комиссар"),
    CommissionerAssistant("Помощник комиссара"),
    Soldier("Рядовой"),
    Patrol("Патруль");

    private final String title;

    PolicemanRanks(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
