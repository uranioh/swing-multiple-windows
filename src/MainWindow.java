import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener, WindowListener {
    JPanel JPanel_top = new JPanel();
    JPanel JPanel_bottom = new JPanel();

    JLabel description = new JLabel("""
            <html>
                <h1>Benvenuto</h1>
                <p>Progetto di <b>Alessandro Melis</b>, <b>Michele Casti</b> ed <b>Elena Sarigu</b></p>
                
                <h2>Per continuare, accedi o registrati.</h2>
            </html>
            """);

    JLabel cat = new JLabel("""
            <html>
                <img src="https://media.tenor.com/SaLG0Kb6zy4AAAAd/oh-the-misery-cat-oh-the-misery-everybody-wants-to-be-my-enemy.gif" alt="cat" width="100" height="100">
            </html>
            """);

    JButton button_login = new JButton("Accedi");
    JButton button_register = new JButton("Registrati");

    public MainWindow() {
        super("java-multiple-windows");

        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));


        JPanel_top.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        JPanel_top.setLayout(new GridLayout(2, 1));

        JPanel_bottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        JPanel_bottom.setLayout(new GridLayout(1, 2, 10, 10));


        button_login.addActionListener(this);
        button_login.setActionCommand("login");
        button_login.setFocusable(false);


        button_register.addActionListener(this);
        button_register.setActionCommand("register");
        button_register.setFocusable(false);
//        Content pane declaration
        JPanel_top.add(description);
        JPanel_top.add(cat);
        c.add(JPanel_top);


        JPanel_bottom.add(button_login);
        JPanel_bottom.add(button_register);
        c.add(JPanel_bottom);

        this.addWindowListener(this);

        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("login")) {
            new LoginWindow(this);
        } else if (e.getActionCommand().equals("register")) {
            new SignUpWindow(this);
        }
    }


    @Override
    public void windowOpened(WindowEvent e) {
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
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}