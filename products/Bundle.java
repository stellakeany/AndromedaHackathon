package products;


import visitor.ItemVisitor;

import java.util.*;

/**
 *  A bundle of items
 */

public class Bundle implements Item {
  
  public Bundle() {
    items = new ArrayList<Item>();
  }

  public void add(Item item) {
    items.add(item);
    Price += item.getPrice();
  }

  public double Price = 0;

  @Override
  public double getPrice() {
    return Price;
  }

  @Override
  public String toString() {
    String description = "Bundle: ";
    for (int i = 0; i < items.size(); i++) {
      description += (items.get(i).toString() + ", ");
    }
    return description.substring(0, description.length() - 2);
  }

  public void accept(ItemVisitor visitor) {
    for (Item item : items) {
      item.accept(visitor);
    }
  }

  private ArrayList<Item> items;
}