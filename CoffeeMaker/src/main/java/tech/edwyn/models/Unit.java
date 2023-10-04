package tech.edwyn.models;

public enum Unit {
    GR("g"),
    ML("ml");

    public final String label;

    Unit(String label) {
        this.label = label;
    }
}
