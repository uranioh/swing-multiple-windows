import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class KeypadWindow extends JDialog implements ActionListener, WindowListener {
    //    imports the KeypadListener interface to be used in the KeypadWindow class to send the result to the parent window(s)
    private final KeypadListener listener;

    //    boolean to check if the KeypadWindow is used for login or not

    //    Components declaration
    JPanel JPanel_top = new JPanel();
    JPanel JPanel_bottom = new JPanel();

    JTextField display = new JTextField(5);
    JButton[][] keypad = new JButton[4][3];

    //    Constructor
    public KeypadWindow(Dialog owner, KeypadListener listener) {
//        JDialog settings
        super(owner, "PIN", true);

//        Imports the KeypadListener interface and the boolean isLogin
        this.listener = listener;

//        Components declaration and layout
        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

//        Keypad display and panel settings
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 52));
        display.setHorizontalAlignment(JTextField.CENTER);

        JPanel_top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_top.setLayout(new GridLayout(1, 1));
        JPanel_top.add(display);


//        Keypad buttons' panel settings
        JPanel_bottom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_bottom.setPreferredSize(new Dimension(JPanel_bottom.getPreferredSize().width, 250));
        JPanel_bottom.setLayout(new GridLayout(4, 3, 10, 10));

//        New JButtons from 1 to 9
        int _i = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keypad[i][j] = new JButton(String.valueOf(_i));
                _i++;
            }
        }

//        New JButtons for C, 0 and OK
        keypad[3][0] = new JButton("C");
        keypad[3][1] = new JButton("0");
        keypad[3][2] = new JButton("OK");
//        Disables the OK button by default
        keypad[3][2].setEnabled(false);

//        JButton settings from 1 to 9
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                keypad[i][j].addActionListener(this);
                keypad[i][j].setActionCommand(keypad[i][j].getText());
                keypad[i][j].setFont(new Font("Arial", Font.BOLD, 20));
            }
        }

//        Adds the JButtons from 1 to 9 to the panel
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JPanel_bottom.add(keypad[i][j]);
            }
        }

//        Adds the JButtons for C, 0 and OK to the panel
        JPanel_bottom.add(keypad[3][0]);
        JPanel_bottom.add(keypad[3][1]);
        JPanel_bottom.add(keypad[3][2]);


//        Adds the panels to the container
        c.add(JPanel_top);
        c.add(JPanel_bottom);

//        Adds the WindowListener to the JDialog
        addWindowListener(this);

//        JDialog settings
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

//        When OK is clicked, the result is sent to the parent window(s) and the JDialog is closed
        if (cmd.equals("OK")) {
            listener.onKeypadResult(display.getText());
        }

//        When C is clicked, the display is cleared and the OK button is disabled
        else if (cmd.equals("C")) {
            keypad[3][2].setEnabled(false);
            display.setText("");
        }

//        number buttons handling
        else {
            if (display.getText().length() < 6) {
                display.setText(display.getText() + cmd);
            }
//            enables the OK button if the pin is 6 digits long
            if (display.getText().length() == 6) {
                keypad[3][2].setEnabled(true);
            }
        }
    }


    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler uscire?", "messaggio importante", JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
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