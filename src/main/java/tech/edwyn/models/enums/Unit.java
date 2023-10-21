package tech.edwyn.models.enums;

public enum Unit {
    GR("g"),
    ML("ml");

    public final String label;

    Unit(String label) {
        this.label = label;
    }
}
