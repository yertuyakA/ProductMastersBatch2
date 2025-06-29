package hw3.mediumsecondpart;

public enum Food {

    MEAT("meat"),
    GRASS("grass");

    private final String type;

    Food(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
