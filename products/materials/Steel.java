package products.materials;

import products.Item;
import visitor.ItemVisitor;

public class Steel extends ItemDecorator {

    final double STEEL_PREMIUM = 10;

    public Steel(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return STEEL_PREMIUM + item.getPrice();
    }

    public double getSteelPremiumPrice() {
        return STEEL_PREMIUM;
    }

    @Override
    public String toString() {
        return "steel " +  item.toString();
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
        item.accept(visitor);
    }
}
