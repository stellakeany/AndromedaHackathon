package invoice;

import products.Item;

/**
 * A simple invoice formatter.
 */

public class SimpleFormatter implements InvoiceFormatter {

  public String formatHeader() {
    return "INVOICE\n=====\n\n";
  }

  public String formatItem(Item item) {
    //return (String.format("%s: %.2f\n", item.toString(), item.getPrice()));
    return item.toString() + ": "+ Math.round(item.getPrice() * 100.0) / 100.0 + "\n";
  }

  public String formatFooter() {
    return "n\\nTOTAL DUE: €" + Math.round(totalPrice * 100.0) / 100.0 + "\n";
    //return (String.format("\n\nTOTAL DUE: €%,.2f\n", totalPrice));
  }
  
  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  private double totalPrice;
}