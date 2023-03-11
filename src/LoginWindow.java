import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

import static javax.swing.SwingConstants.RIGHT;

public class LoginWindow extends JDialog implements ActionListener, WindowListener, KeypadListener {
    private final JFrame parentFrame;

    String keypadPin;
    JPanel JPanel_top = new JPanel();
    JPanel JPanel_bottom = new JPanel();

    JLabel label_username = new JLabel("Username", RIGHT);
    JLabel label_password = new JLabel("Password", RIGHT);

    JTextField field_username = new JTextField();
    JPasswordField field_password = new JPasswordField();

    JButton button_confirm = new JButton("Invio");
    JButton button_cancel = new JButton("Annulla");

    public LoginWindow(Frame parent) {
        super(parent, "Login", true);
        parentFrame = (JFrame) parent;

        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        JPanel_top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_top.setLayout(new GridLayout(2, 1, 10, 10));

        JPanel_bottom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_bottom.setLayout(new GridLayout(1, 3, 10, 10));


        button_confirm.addActionListener(this);
        button_confirm.setActionCommand("confirm");

        button_cancel.addActionListener(this);
        button_cancel.setActionCommand("cancel");


        JPanel_top.add(label_username);
        JPanel_top.add(field_username);
        JPanel_top.add(label_password);
        JPanel_top.add(field_password);
        c.add(JPanel_top);


        JPanel_bottom.add(button_confirm);
        JPanel_bottom.add(button_cancel);
        c.add(JPanel_bottom);

        addWindowListener(this);

        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private boolean checkCredentials() {
        boolean user_state = true;
        boolean pw_state = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/users.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[2].equals(field_username.getText())) {
                    user_state = false;
                }
                if (data[3].equals(new String(field_password.getPassword()))) {
                    pw_state = false;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return !user_state && !pw_state;
    }

    private String getPin() {
        String pin = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/users.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[2].equals(field_username.getText())) {
                    if (data[3].equals(new String(field_password.getPassword()))) {
                        pin = data[7];
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pin;
    }

    private void checkPin() {
        if (keypadPin.equals(getPin())) {
            new LoggedInWindow(field_username.getText()).setSize(300, 400);
            this.dispose();
            parentFrame.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Pin errato", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirm")) {
            if (checkCredentials()) {
                new KeypadWindow(this, this, true);
            } else {
                JOptionPane.showMessageDialog(this, "Username o password errati", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getActionCommand().equals("cancel")) {
            this.dispose();
        }
    }


    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

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

    @Override
    public void onKeypadResult(String result) {
        keypadPin = result;
        checkPin();
    }
}