/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productapp;

/**
 *
 * @author Student
 */
import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ProductForm extends JFrame {

    private JTextField txtCustomerName;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess;

    public ProductForm() {

        setTitle("Product App");
        setSize(550, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        // Create form components
        JLabel lblCustomer = new JLabel("Customer Name:");
        JLabel lblProduct = new JLabel("Select Product:");
        JLabel lblPrice = new JLabel("Enter Price:");

        txtCustomerName = new JTextField(20);
        txtPrice = new JTextField(20);

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        cmbProduct = new JComboBox<>(products);

        btnProcess = new JButton("PROCESS");

        // Create layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(12, 10, 12, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblCustomer, gbc);

        gbc.gridx = 1;
        panel.add(txtCustomerName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblProduct, gbc);

        gbc.gridx = 1;
        panel.add(cmbProduct, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblPrice, gbc);

        gbc.gridx = 1;
        panel.add(txtPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(btnProcess, gbc);

        add(panel);

        // Button events
        btnProcess.addActionListener(e -> processSale());

        // Menu events
        processItem.addActionListener(e -> processSale());

        clearItem.addActionListener(e -> clearForm());

        exitItem.addActionListener(e -> System.exit(0));
    }

    // Process sales information
    private void processSale() {

        try {

            String customer = txtCustomerName.getText().trim();
            String product = cmbProduct.getSelectedItem().toString();

            if (customer.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please enter the customer name.");
                return;
            }

            if (txtPrice.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please enter the product price.");
                return;
            }

            double price = Double.parseDouble(txtPrice.getText().trim());

            if (!Double.isFinite(price) || price < 0) {
                JOptionPane.showMessageDialog(this,
                    "Please enter a valid positive price.");
                return;
            }

            // Create calculations object
            ProductCalculations calculations =
                    new ProductCalculations(price);

            double vat = calculations.GetVat();
            double commission = calculations.GetCommission();
            double total = calculations.GetTotal();

            // Save information to file
            saveToFile(customer, product, vat, commission, total);

            // Display results
            String message =
                    "Customer Name: " + customer +
                    "\nProduct: " + product +
                    "\nVAT: R " + vat +
                    "\nCOMMISSION: R " + commission +
                    "\nTOTAL: R " + total;

            JOptionPane.showMessageDialog(this,
                    message,
                    "Sales Information",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "Please enter a valid numerical price.");

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(this,
                    "Error saving data: " + ex.getMessage());
        }
    }

    // Save sales information to data.txt
    private void saveToFile(String customer, String product,
            double vat, double commission, double total)
            throws IOException {

        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get("data.txt"),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            writer.write("DATA LOG");
            writer.newLine();

            writer.write("********************************");
            writer.newLine();

            writer.write("Customer Name: " + customer);
            writer.newLine();

            writer.write("Product: " + product);
            writer.newLine();

            writer.write("VAT: R " + vat);
            writer.newLine();

            writer.write("COMMISSION: R " + commission);
            writer.newLine();

            writer.write("TOTAL: R " + total);
            writer.newLine();

            writer.write("********************************");
            writer.newLine();
        }
    }

    // Clear all fields
    private void clearForm() {

        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

}
