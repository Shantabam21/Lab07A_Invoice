import java.util.ArrayList;

public class Invoice {
    private ArrayList<LineItem> lineItems = new ArrayList<>();


    public void addItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    public double getTotalAmount() {
        double total = 0;
        for (LineItem item : lineItems) {
            total += item.getTotal();
        }
        return total;
    }

    public String getInvoiceDetails() {
        StringBuilder sb = new StringBuilder();
        for (LineItem item : lineItems) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("---------------------------------------------\nTotal Due: $").append(String.format("%.2f", getTotalAmount()));
        return sb.toString();
    }
    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }
    public void setLineItems(ArrayList<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
