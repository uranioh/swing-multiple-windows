import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginWindow extends JDialog implements ActionListener, WindowListener, KeypadListener {
    private final JFrame parentFrame;

    String keypadPin;
    JPanel JPanel_top = new JPanel();
    JPanel JPanel_bottom = new JPanel();

    JLabel label_username = new JLabel("Username");
    JLabel label_password = new JLabel("Password");

    JTextField field_username = new JTextField();
    JPasswordField field_password = new JPasswordField();

    JButton button_confirm = new JButton("Invio");
    JButton button_cancel = new JButton("Annulla");

    //    Constructor
    public LoginWindow(Frame parent) {
//        JDialog settings
        super(parent, "Login", true);

//        Components declaration and layout
        parentFrame = (JFrame) parent;
        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

//        JPanels layout and border declaration
        JPanel_top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_top.setLayout(new GridLayout(2, 1, 10, 10));

        JPanel_bottom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_bottom.setLayout(new GridLayout(1, 3, 10, 10));

//        Top panel components' actions
        button_confirm.addActionListener(this);
        button_confirm.setActionCommand("confirm");

        button_cancel.addActionListener(this);
        button_cancel.setActionCommand("cancel");

//        Top panel components
        JPanel_top.add(label_username);
        JPanel_top.add(field_username);
        JPanel_top.add(label_password);
        JPanel_top.add(field_password);
        c.add(JPanel_top);

//        Bottom panel components
        JPanel_bottom.add(button_confirm);
        JPanel_bottom.add(button_cancel);
        c.add(JPanel_bottom);

//        Window settings
        addWindowListener(this);

        setResizable(false);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    //    Check if the credentials are correct
    private boolean checkCredentials() {
//        Set the default state of the credentials to false
        boolean user_state = false;
        boolean pw_state = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/users.txt"));
            String line;
//            Read the file line by line
            while ((line = br.readLine()) != null) {
//                Split the line by the comma
                String[] data = line.split(",");

//                Check if the username and password are correct
                if (data[2].equals(field_username.getText())) {
                    user_state = true;
                }
                if (data[3].equals(new String(field_password.getPassword()))) {
                    pw_state = true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Return true if both the username and password are correct
        return user_state && pw_state;
    }


    //    Get the pin based on the username and password
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

    //    Check if the pin is correct
    private void checkPin() {
        if (keypadPin.equals(getPin())) {
            new LoggedInWindow(field_username.getText()).setSize(600, 400);
            this.dispose();
            parentFrame.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Pin errato", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    //    Action listener
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirm")) {
//            Open the keypad window if the credentials are correct, otherwise show an error message
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


    //    Custom interface: KeypadListener - get the pin from the keypad when it gets confirmed
    @Override
    public void onKeypadResult(String result) {
        keypadPin = result;
        checkPin();
    }
}