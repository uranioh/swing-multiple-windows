import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SignUpWindow extends JFrame implements ActionListener, WindowListener {
    JPanel JPanel_top = new JPanel();
    JPanel JPanel_bottom = new JPanel();

    JLabel label_fName = new JLabel("Nome");
    JLabel label_lName = new JLabel("Cognome");
    JLabel label_username = new JLabel("Username");
    JLabel label_password = new JLabel("Password");
    JLabel label_confirm = new JLabel("Conferma Password");

    JTextField field_fName = new JTextField();
    JTextField field_lName = new JTextField();
    JTextField field_username = new JTextField();
    JTextField field_password = new JTextField();
    JTextField field_confirm = new JTextField();

    ButtonGroup buttonGroup_gender = new ButtonGroup();
    JRadioButton radioButton_male = new JRadioButton("Maschio");
    JRadioButton radioButton_female = new JRadioButton("Femmina");

    JButton button_confirm = new JButton("Invia");
    JButton button_cancel = new JButton("Annulla");


    JLabel label_province = new JLabel("Provincia");
    String[] array_province = {"Selargius", "Cagliari", "Villasor", "Domus de Maria", "Napoli"};
    JComboBox<String> combobox_province = new JComboBox<>(array_province);

    JLabel label_city = new JLabel("Città");
    JTextField field_city = new JTextField();

    public SignUpWindow() {
        super("Crea nuovo Account");

        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

//        JPanels layout declaration
        JPanel_top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_top.setLayout(new GridLayout(8, 2, 10, 10));

        JPanel_bottom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel_bottom.setLayout(new GridLayout(2, 2));

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


        radioButton_male.setActionCommand("Maschio");
        radioButton_female.setActionCommand("Femmina");
        buttonGroup_gender.add(radioButton_male);
        buttonGroup_gender.add(radioButton_female);
        JPanel_top.add(radioButton_male);
        JPanel_top.add(radioButton_female);

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
        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.addWindowListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirm")) {
            if (field_fName.getText().isEmpty() || field_lName.getText().isEmpty() || field_username.getText().isEmpty() || field_password.getText().isEmpty() || field_confirm.getText().isEmpty() || buttonGroup_gender.getSelection() == null || field_city.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Completa tutti i campi", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {
                if (field_password.getText().equals(field_confirm.getText())) {
                    System.out.println("Nome: " + field_fName.getText());
                    System.out.println("Cognome: " + field_lName.getText());
                    System.out.println("Username: " + field_username.getText());
                    System.out.println("Password: " + field_password.getText());
                    System.out.println("Conferma Password: " + field_confirm.getText());
                    System.out.println("ahah sex: " + buttonGroup_gender.getSelection().getActionCommand());
                    System.out.println("Provincia: " + combobox_province.getSelectedItem());
                    System.out.println("Città: " + field_city.getText());
                    JOptionPane.showMessageDialog(this, "Registrazione effettuata con successo", "Successo", JOptionPane.INFORMATION_MESSAGE);

                    new KeypadWindow();
                } else {
                    JOptionPane.showMessageDialog(this, "Le password non corrispondono", "Errore", JOptionPane.ERROR_MESSAGE);
                }
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