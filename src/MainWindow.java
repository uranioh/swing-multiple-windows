import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener, WindowListener {
    JPanel JPanel_top = new JPanel();
    JPanel JPanel_bottom = new JPanel();

    JLabel loginString = new JLabel("Premi 'Accedi' per effettuare il login ");
    JLabel registerString = new JLabel("'Registrati' per effettuare la registrazione");

    JButton button_login = new JButton("Accedi");
    JButton button_register = new JButton("Registrati");

    public MainWindow() {
        super("Destinazione: ");

        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));


        JPanel_top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel_top.setLayout(new GridLayout(2, 1));

        JPanel_bottom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel_bottom.setLayout(new GridLayout(1, 2));


        button_login.addActionListener(this);
        button_login.setActionCommand("login");
        button_register.addActionListener(this);
        button_register.setActionCommand("register");


        loginString.setFont(new Font("Arial", Font.BOLD, 16));
        loginString.setOpaque(true);
        registerString.setFont(new Font("Arial", Font.BOLD, 16));
        registerString.setOpaque(true);


//        Content pane declaration
        JPanel_top.add(loginString);
        JPanel_top.add(registerString);
        c.add(JPanel_top);


        JPanel_bottom.add(button_login);
        JPanel_bottom.add(button_register);
        c.add(JPanel_bottom);

        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.addWindowListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("login")) {
            LoginWindow w = new LoginWindow();
            w.setBounds(700, 200, 500, 350);

//            KeypadWindow test4 = new KeypadWindow();
//            test4.setBounds(700, 200, 500, 350);
//            test4.getContentPane().setBackground(Color.BLACK);


        } else if (e.getActionCommand().equals("register")) {
            SignUpWindow w = new SignUpWindow();
            w.setBounds(700, 200, 600, 450);

//            KeypadWindow w = new KeypadWindow();
//            w.setBounds(700, 200, 350, 400);
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