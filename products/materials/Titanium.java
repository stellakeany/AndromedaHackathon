package products.materials;

import products.Item;
import visitor.ItemVisitor;

public class Titanium extends ItemDecorator {

    final double TITANIUM_PREMIUM = 50;

    public Titanium(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return TITANIUM_PREMIUM + item.getPrice();
    }

    public double getTitaniumPremiumPrice() {
        return TITANIUM_PREMIUM;
    }
    @Override
    public String toString() {
        return "titanium " + item.toString();
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.visit(this);
        item.accept(visitor);
    }
}
