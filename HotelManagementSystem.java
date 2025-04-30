import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JLabel nameLabel, daysLabel, roomLabel, checkinLabel, checkoutLabel;
    JTextField nameField, daysField, checkinField, checkoutField;
    JComboBox<String> roomBox;
    JButton submitButton;
    JTextArea billArea;

    public HotelManagementSystem() {
        setTitle("Hotel Management System");
        setSize(600, 600);
        setLayout(null);

        // Customer Name
        nameLabel = new JLabel("Customer Name:");
        nameLabel.setBounds(30, 30, 150, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 30, 300, 30);
        add(nameField);

        // Number of Days
        daysLabel = new JLabel("Number of Days:");
        daysLabel.setBounds(30, 80, 150, 30);
        add(daysLabel);

        daysField = new JTextField();
        daysField.setBounds(200, 80, 300, 30);
        add(daysField);

        // Check-in Date
        checkinLabel = new JLabel("Check-in Date (DD/MM/YYYY):");
        checkinLabel.setBounds(30, 130, 200, 30);
        add(checkinLabel);

        checkinField = new JTextField();
        checkinField.setBounds(250, 130, 250, 30);
        add(checkinField);

        // Check-out Date
        checkoutLabel = new JLabel("Check-out Date (DD/MM/YYYY):");
        checkoutLabel.setBounds(30, 180, 200, 30);
        add(checkoutLabel);

        checkoutField = new JTextField();
        checkoutField.setBounds(250, 180, 250, 30);
        add(checkoutField);

        // Room Type
        roomLabel = new JLabel("Room Type:");
        roomLabel.setBounds(30, 230, 150, 30);
        add(roomLabel);

        String[] rooms = {"Single - ₹100/day", "Double - ₹150/day"};
        roomBox = new JComboBox<>(rooms);
        roomBox.setBounds(200, 230, 300, 30);
        add(roomBox);

        // Submit Button
        submitButton = new JButton("Generate Bill");
        submitButton.setBounds(200, 280, 150, 40);
        submitButton.addActionListener(this);
        add(submitButton);

        // Bill Area
        billArea = new JTextArea();
        billArea.setBounds(30, 340, 520, 200);
        billArea.setEditable(false);
        billArea.setFont(new Font("Arial", Font.PLAIN, 14));
        add(billArea);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String name = nameField.getText();
            int days = Integer.parseInt(daysField.getText());
            String checkinDate = checkinField.getText();
            String checkoutDate = checkoutField.getText();
            String roomType = roomBox.getSelectedItem().toString();
            int pricePerDay = roomBox.getSelectedIndex() == 0 ? 100 : 150;

            int totalBill = days * pricePerDay;

            // Generate bill text
            String bill = "-------------------------------------------\n";
            bill += "            Hotel Bill Summary\n";
            bill += "-------------------------------------------\n";
            bill += "Customer Name : " + name + "\n";
            bill += "Check-in Date : " + checkinDate + "\n";
            bill += "Check-out Date: " + checkoutDate + "\n";
            bill += "Room Type     : " + roomType + "\n";
            bill += "Days Stayed   : " + days + "\n";
            bill += "Price/Day     : ₹" + pricePerDay + "\n";
            bill += "-------------------------------------------\n";
            bill += "Total Bill    : ₹" + totalBill + "\n";
            bill += "-------------------------------------------\n";
            bill += "Thank you for staying with us!\n";

            // Show bill in TextArea
            billArea.setText(bill);

            // Show Thank You pop-up
            JOptionPane.showMessageDialog(this, "Thank you for coming!", "Visit Again", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number of days.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
