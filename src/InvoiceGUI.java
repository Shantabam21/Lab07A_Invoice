import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InvoiceGUI extends JFrame {
    JPanel mainPanel;
    JPanel topPanel;
    JPanel bottomPanel;
    private JTextField productNameField, priceField, quantityField;
    private JTextArea outputArea;
    private Invoice invoice;

    public InvoiceGUI() {
        invoice = new Invoice();


        setTitle("Invoice");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        createTopPanel();

        createBottomPanel();

        JPanel centerWrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        centerWrapperPanel.add(bottomPanel);

        mainPanel.add(centerWrapperPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    public void createTopPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1, 5, 5));
        JLabel title = new JLabel("Invoice");
        title.setFont(new Font("Times New Roman", Font.BOLD, 50));
        title.setHorizontalAlignment(JLabel.CENTER);

        JTextArea customerInfo = new JTextArea(
                "Sam's Small Appliences\n100 Main Street\nAnytown, CA 98765"
        );
        customerInfo.setEditable(false); // prevents user from editing
        customerInfo.setBackground(topPanel.getBackground()); // make it blend with panel
        customerInfo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        customerInfo.setWrapStyleWord(true);
        customerInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        customerInfo.setOpaque(false);

        topPanel.add(title);
        JPanel infoWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // The JTextArea will be added to this FlowLayout panel, respecting its size and centering it.
        infoWrapper.add(customerInfo);

        // Add the wrapper panel to the main topPanel's GridLayout cell
        topPanel.add(infoWrapper);
        mainPanel.add(topPanel, BorderLayout.NORTH);
    }
    public void createBottomPanel() {
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        inputPanel.add((new JLabel("Product Name:")));
        productNameField = new JTextField(10);
        inputPanel.add((productNameField));

        inputPanel.add((new JLabel("Unit Price:")));
        priceField = new JTextField(5);
        inputPanel.add(priceField);

        inputPanel.add((new JLabel("Quantity:")));
        quantityField = new JTextField(5);
        inputPanel.add(quantityField);

        JButton addButton = new JButton("Add Item");
        inputPanel.add(addButton);
        inputPanel.add(addButton);
        bottomPanel.add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea(10, 30);
        outputArea.setText("Item\tQty\tPrice\tTotal\n---------------------------------------------\n");
        outputArea.setEditable(false);
        bottomPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        addButton.addActionListener(e -> {
            String name = productNameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Product product = new Product(name, price);
            LineItem item = new LineItem(product, quantity);
            invoice.addItem(item);

            outputArea.setText("Item\tQty\tPrice\tTotal\n---------------------------------------------\n" + invoice.getInvoiceDetails());
        });
        mainPanel.add(bottomPanel, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        new InvoiceGUI();
    }
}