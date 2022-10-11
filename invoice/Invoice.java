package invoice;

import products.Item;
import visitor.ItemVisitor;
import visitor.PriceCalculator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An invoice for a sale, consisting of items.
 */

public class Invoice {

  public Invoice() {
    items = new ArrayList<Item>();
  }
  
  //public Invoice(ArrayList<Item> initialItems) {items = initialItems;}
  
  public void addItem(Item item) {
    items.add(item);
  }


  // Return an iterator for the items.
  public Iterator<Item> getItems() {
    return new Iterator<Item>() {
      public boolean hasNext() {
        return current < items.size();
      }

      public Item next() {
        return items.get(current++);
      }

      public void remove() {
        throw new UnsupportedOperationException();
      }

      private int current = 0;
    };
  }

  public String format(InvoiceFormatter formatter) {
    String formattedInvoice = formatter.formatHeader();
    Iterator<Item> iter = getItems();
    for(int i =0; i< items.size(); i++){
      formattedInvoice += formatter.formatItem(iter.next());
    }
    //PriceCalculator calculator = new PriceCalculator();
    //while (iter.hasNext()) {
      //Item item = iter.next();
      //formattedInvoice += formatter.formatItem(iter.next());
      //accept(calculator);
      //formatter.setTotalPrice(calculator.getTotalPrice());
    //}
    formattedInvoice += formatter.formatFooter();
    return formattedInvoice;
  }

  public void accept(ItemVisitor visitor) {
    Iterator<Item> iter = getItems();
    for(int i=0;i< items.size();i++){
      iter.next().accept(visitor);
    }
   // while (iter.hasNext())
     // iter.next().accept(visitor);
  }

  private ArrayList<Item> items;
}