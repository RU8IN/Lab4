package all.Enums;

public enum HouseParts {
    NORTH_WALL("северной стороны"),
    EAST_WALL("восточной стороны"),
    SOUTH_WALL("южной стороны"),
    WEST_WALL("западной стороны"),
    ROOF("(крыша)"),
    FLOOR("(пол)");

    private final String title;

    HouseParts(String title) {
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
