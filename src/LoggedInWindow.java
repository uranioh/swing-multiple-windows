import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static javax.swing.SwingConstants.RIGHT;

public class LoggedInWindow extends JFrame {
    String loggedUsername;

    JPanel main = new JPanel();

    JLabel label_fName = new JLabel("Nome", RIGHT);
    JLabel label_lName = new JLabel("Cognome", RIGHT);
    JLabel label_username = new JLabel("Username", RIGHT);
    JLabel label_password = new JLabel("Password", RIGHT);
    JLabel label_gender = new JLabel("Sesso", RIGHT);
    JLabel label_province = new JLabel("Provincia", RIGHT);
    JLabel label_city = new JLabel("Città", RIGHT);
    JLabel label_pin = new JLabel("PIN", RIGHT);


    JTextField field_fName = new JTextField();
    JTextField field_lName = new JTextField();
    JTextField field_username = new JTextField();
    JTextField field_password = new JTextField();
    JTextField field_gender = new JTextField();
    JTextField field_province = new JTextField();
    JTextField field_city = new JTextField();
    JTextField field_pin = new JTextField();


    public LoggedInWindow(String loggedUsername) {
        super("Malvenuto");
        this.loggedUsername = loggedUsername;

        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        setFields();

        main.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        field_fName.setEditable(false);
        field_lName.setEditable(false);
        field_username.setEditable(false);
        field_password.setEditable(false);
        field_gender.setEditable(false);
        field_province.setEditable(false);
        field_city.setEditable(false);
        field_pin.setEditable(false);

        main.setLayout(new GridLayout(8, 2, 10, 10));
        main.add(label_fName);
        main.add(field_fName);
        main.add(label_lName);
        main.add(field_lName);
        main.add(label_username);
        main.add(field_username);
        main.add(label_password);
        main.add(field_password);
        main.add(label_gender);
        main.add(field_gender);
        main.add(label_province);
        main.add(field_province);
        main.add(label_city);
        main.add(field_city);
        main.add(label_pin);
        main.add(field_pin);

        c.add(main);

        setLocationRelativeTo(null);
        setSize(600, 800);
        this.pack();
        this.setVisible(true);
    }

    public void setFields() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/users.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[2].equals(loggedUsername)) {
                    field_fName.setText(data[0]);
                    field_lName.setText(data[1]);
                    field_username.setText(data[2]);
                    field_password.setText(data[3]);
                    field_gender.setText(data[4]);
                    field_province.setText(data[5]);
                    field_city.setText(data[6]);
                    field_pin.setText(data[7]);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
