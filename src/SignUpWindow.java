import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class SignUpWindow extends JDialog implements ActionListener, WindowListener, KeypadListener {
    String pin;

    //    JPanels declaration
    JPanel JPanel_top = new JPanel();
    JPanel JPanel_bottom = new JPanel();

    //    JLabels declaration
    JLabel label_fName = new JLabel("Nome");
    JLabel label_lName = new JLabel("Cognome");
    JLabel label_username = new JLabel("Username");
    JLabel label_password = new JLabel("Password");
    JLabel label_confirm = new JLabel("Conferma password");
    JLabel label_gender = new JLabel("Sesso");
    JLabel label_province = new JLabel("Provincia");
    JLabel label_city = new JLabel("Città");

    //    Input fields declaration
    JTextField field_fName = new JTextField();
    JTextField field_lName = new JTextField();
    JTextField field_username = new JTextField();
    JPasswordField field_password = new JPasswordField();
    JPasswordField field_confirm = new JPasswordField();
    //  Gender radio buttons
    JPanel JPanel_genderGroup = new JPanel();
    ButtonGroup buttonGroup_gender = new ButtonGroup();
    JRadioButton radioButton_male = new JRadioButton("Maschio");
    JRadioButton radioButton_female = new JRadioButton("Femmina");
    //    Province combobox
    String[] array_province = {"Selargius", "Cagliari", "Villasor", "Domus De Maria", "Napoli"};
    JComboBox<String> combobox_province = new JComboBox<>(array_province);
    //    City text field
    JTextField field_city = new JTextField();

    //    Bottom panel buttons
    JButton button_confirm = new JButton("Invia");
    JButton button_cancel = new JButton("Annulla");

    //    Constructor
    public SignUpWindow(Frame parent) {
//        JDialog settings
        super(parent, "Registrazione", true);

//        Components declaration and layout
        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

//        JPanels layout declaration
        JPanel_top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_top.setLayout(new GridLayout(8, 2, 10, 10));

        JPanel_bottom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_bottom.setLayout(new GridLayout(1, 2, 10, 10));

//        Top panel components
        JPanel_top.add(label_fName);
        JPanel_top.add(field_fName);

        JPanel_top.add(label_lName);
        JPanel_top.add(field_lName);

        JPanel_top.add(label_username);
        JPanel_top.add(field_username);

        JPanel_top.add(label_password);
        JPanel_top.add(field_password);

        JPanel_top.add(label_confirm);
        JPanel_top.add(field_confirm);

//        Gender selection properties
        radioButton_male.setActionCommand("Maschio");
        radioButton_female.setActionCommand("Femmina");
        buttonGroup_gender.add(radioButton_male);
        buttonGroup_gender.add(radioButton_female);
        JPanel_genderGroup.setLayout(new GridLayout(1, 2, 10, 10));
        JPanel_genderGroup.add(radioButton_male);
        JPanel_genderGroup.add(radioButton_female);

        JPanel_top.add(label_gender);
        JPanel_top.add(JPanel_genderGroup);

        JPanel_top.add(label_province);
        JPanel_top.add(combobox_province);

        JPanel_top.add(label_city);
        JPanel_top.add(field_city);

        c.add(JPanel_top);

//        Bottom panel components
        button_confirm.addActionListener(this);
        button_confirm.setActionCommand("confirm");
        JPanel_bottom.add(button_confirm);

        button_cancel.addActionListener(this);
        button_cancel.setActionCommand("cancel");
        JPanel_bottom.add(button_cancel);

        c.add(JPanel_bottom);

//        Window settings
        addWindowListener(this);

        setResizable(false);
        setSize(400, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //    writeToFile method - writes the user data to the users.txt file
    public void writeToFile() {
//        Temporary variables to store the data - they are used to capitalize the first letter of the name, surname and city
        String _fName = field_fName.getText().substring(0, 1).toUpperCase() + field_fName.getText().substring(1).toLowerCase();
        String _lName = field_lName.getText().substring(0, 1).toUpperCase() + field_lName.getText().substring(1).toLowerCase();
        String _username = field_username.getText();
        String _password = new String(field_password.getPassword());
        String _gender = buttonGroup_gender.getSelection().getActionCommand();
        String _province = Objects.requireNonNull(combobox_province.getSelectedItem()).toString();
        String _city = field_city.getText().substring(0, 1).toUpperCase() + field_city.getText().substring(1);

        try {
            FileWriter fw = new FileWriter("src/users.txt", true);
//            Writes the data to the file and adds a new line
            fw.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s", _fName, _lName, _username, _password, _gender, _province, _city, pin));
            fw.write(System.lineSeparator());
            fw.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    //    Custom interface: KeypadListener - get the pin from the keypad when it gets confirmed
    @Override
    public void onKeypadResult(String result) {
        pin = result;
        writeToFile();
        JOptionPane.showMessageDialog(this, "Registrazione avvenuta con successo!");
        this.dispose();
    }

    //    Method to check if the username is already taken
    public boolean checkUsername(String username) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/users.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[2].equals(username)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }

    //    Action listener
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirm")) {
//            Checks if the fields are empty
            if (field_fName.getText().isEmpty() || field_lName.getText().isEmpty() || field_username.getText().isEmpty() || new String(field_password.getPassword()).isEmpty() || new String(field_confirm.getPassword()).isEmpty() || buttonGroup_gender.getSelection() == null || field_city.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Completa tutti i campi", "Errore", JOptionPane.ERROR_MESSAGE);
            }
//            Checks if the password and the confirmation match
            else if (!new String(field_password.getPassword()).equals(new String(field_confirm.getPassword()))) {
                JOptionPane.showMessageDialog(this, "Le password non corrispondono", "Errore", JOptionPane.ERROR_MESSAGE);
            }
//            Checks if the password is at least 8 characters long
            else if (new String(field_password.getPassword()).length() < 8) {
                JOptionPane.showMessageDialog(this, "La password deve contenere almeno 8 caratteri", "Errore", JOptionPane.ERROR_MESSAGE);
            }
//            Checks if the username is already taken
            else if (checkUsername(field_username.getText())) {
                JOptionPane.showMessageDialog(this, "Username già esistente", "Errore", JOptionPane.ERROR_MESSAGE);
            }
//            Opens the keypad window if all the checks are passed
            else {
                new KeypadWindow(this, this, false);
            }
        }

        if (e.getActionCommand().equals("cancel")) {
            this.dispose();
        }
    }


    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }
}