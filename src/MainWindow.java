import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainWindow extends JFrame implements ActionListener, WindowListener {
    //    JPanel declaration
    JPanel JPanel_top = new JPanel();
    JPanel JPanel_bottom = new JPanel();

    //    JLabels with HTML - description and cat
    JLabel description = new JLabel("""
            <html>
                <h1>Benvenuto</h1>
                <p>Progetto di <b>Alessandro Melis</b>, <b>Michele Casti</b> ed <b>Elena Sarigu</b></p>
                
                <h2>Per continuare, accedi o registrati.</h2>
            </html>
            """);

    JLabel cat = new JLabel("""
            <html>
                <img src="file:src/images/cat.gif" alt="cat" width="100" height="100">
            </html>
            """);


    //    JButton declaration
    JButton button_login = new JButton("Accedi");
    JButton button_register = new JButton("Registrati");

    //    Constructor
    public MainWindow() {
//        JFrame settings
        super("Swing Project");

//        Components declaration and layout
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

//        Top panel components
        JPanel_top.add(description);
        JPanel_top.add(cat);
        c.add(JPanel_top);

//        Bottom panel components
        JPanel_bottom.add(button_login);
        JPanel_bottom.add(button_register);
        c.add(JPanel_bottom);

        addWindowListener(this);

        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    //    Action listener - opens the desired window
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
        int r = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler uscire?", "Chiusura del programma", JOptionPane.YES_NO_OPTION);
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