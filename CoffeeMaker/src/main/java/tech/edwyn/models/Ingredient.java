package tech.edwyn.models;

public class Ingredient {

    private IngredientName name;
    private int quantity;
    private Unit unit;

    public Ingredient(IngredientName name, int quantity, Unit unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredient{");
        sb.append("name='").append(name).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", unit=").append(unit);
        sb.append('}');
        return sb.toString();
    }
}
enum IngredientName {
    BEANS, WATER, MILK
}