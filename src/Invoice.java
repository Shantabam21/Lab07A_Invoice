import java.util.ArrayList;

public class Invoice {
    private ArrayList<LineItem> lineItems;


    public void addItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    public double getTotalAmount() {
        double total = 0;
        for (LineItem item : lineItems) {}
            total += item.getTotal();
        return total;
    }

    public String getInvoiceDetails() {
        StringBuilder sb = new StringBuilder();
        for (LineItem item : items) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Total Due: $" + getTotalAmount());
        return sb.toString();
    }
    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }
    public void setLineItems(ArrayList<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
