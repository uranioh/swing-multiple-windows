import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeypadWindow extends JFrame implements ActionListener, WindowListener {
    JPanel JPanel_top = new JPanel();
    JPanel JPanel_bottom = new JPanel();

    JTextField display = new JTextField(5);
    JButton[][] keypad = new JButton[4][3];

    public KeypadWindow() {
        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 52));
        display.setHorizontalAlignment(JTextField.CENTER);

        JPanel_top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_top.setLayout(new GridLayout(1, 1));
        JPanel_top.add(display);

        int _i = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keypad[i][j] = new JButton(String.valueOf(_i));
                _i++;
            }
        }

        keypad[3][0] = new JButton("C");
        keypad[3][1] = new JButton("0");
        keypad[3][2] = new JButton("OK");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                keypad[i][j].addActionListener(this);
                keypad[i][j].setActionCommand(keypad[i][j].getText());
                keypad[i][j].setFont(new Font("Arial", Font.BOLD, 20));
            }
        }

        JPanel_bottom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_bottom.setPreferredSize(new Dimension(JPanel_bottom.getPreferredSize().width, 250));
        JPanel_bottom.setLayout(new GridLayout(4, 3, 10, 10));


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JPanel_bottom.add(keypad[i][j]);
            }
        }

        JPanel_bottom.add(keypad[3][0]);
        JPanel_bottom.add(keypad[3][1]);
        JPanel_bottom.add(keypad[3][2]);


        c.add(JPanel_top);
        c.add(JPanel_bottom);


        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("OK")) {
            System.out.println("OK");
        } else if (cmd.equals("C")) {
            display.setText("");
        } else {
            display.setText(display.getText() + cmd);
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