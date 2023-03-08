import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginWindow extends JFrame implements ActionListener, WindowListener {
    JPanel JPanel_top = new JPanel();
    JPanel JPanel_bottom = new JPanel();

    JLabel label_username = new JLabel("Username");
    JLabel label_password = new JLabel("Password");

    JTextField field_username = new JTextField();
    JTextField field_password = new JTextField();

    JButton button_confirm = new JButton("Invio");
    JButton button_cancel = new JButton("Annulla");

    public LoginWindow() {
        super("Verifica di informatica Casti Michele 4C");

        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        JPanel_top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_top.setLayout(new GridLayout(2, 1));

        JPanel_bottom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel_bottom.setLayout(new GridLayout(1, 3));


        button_confirm.addActionListener(this);
        button_confirm.setActionCommand("confirm");

        button_cancel.addActionListener(this);
        button_cancel.setActionCommand("cancel");


        label_username.setFont(new Font("Arial", Font.BOLD, 16));
        label_password.setFont(new Font("Arial", Font.BOLD, 16));
        field_username.setFont(new Font("Arial", Font.BOLD, 10));
        field_password.setFont(new Font("Arial", Font.BOLD, 10));


        JPanel_top.add(label_username);
        JPanel_top.add(field_username);
        JPanel_top.add(label_password);
        JPanel_top.add(field_password);
        c.add(JPanel_top);


        JPanel_bottom.add(button_confirm);
        JPanel_bottom.add(button_cancel);
        c.add(JPanel_bottom);

        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.addWindowListener(this);
    }


    public void actionPerformed(ActionEvent e) {

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
}