import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginWindow extends JFrame implements ActionListener, WindowListener {
    int placeholder;
    JLabel testo1 = new JLabel("Username");
    JLabel testo2 = new JLabel("Password");
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JButton bottone1 = new JButton("indietro");
    JButton bottone2 = new JButton("Invio");
    JButton bottone3 = new JButton("Annulla");

    public LoginWindow() {
        super("Verifica di informatica Casti Michele 4C");
        Container c = this.getContentPane();

        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        JPanel superiore = new JPanel();
        JPanel inferiore = new JPanel();

        superiore.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        superiore.setLayout(new GridLayout(2, 1));


        inferiore.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inferiore.setLayout(new GridLayout(1, 3));


        bottone1.addActionListener(this);
        bottone1.setActionCommand("bottone1");
        bottone2.addActionListener(this);
        bottone2.setActionCommand("bottone2");
        bottone2.addActionListener(this);
        bottone3.setActionCommand("bottone3");
        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.addWindowListener(this);

        testo1.setFont(new Font("Arial", Font.BOLD, 16));
        testo2.setFont(new Font("Arial", Font.BOLD, 16));
        t1.setFont(new Font("Arial", Font.BOLD, 10));
        t2.setFont(new Font("Arial", Font.BOLD, 10));


        superiore.add(testo1);
        superiore.add(t1);
        superiore.add(testo2);

        superiore.add(t2);
        c.add(superiore);


        inferiore.add(bottone2);
        inferiore.add(bottone3);


        c.add(inferiore);


    }


    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("bottone1")) {

            LoginWindow test2 = new LoginWindow();
            test2.setBounds(700, 200, 500, 350);
            test2.getContentPane().setBackground(Color.BLACK);

            test2.setForeground(Color.WHITE);

        } else if (e.getActionCommand().equals("bottone2")) {

            SignUpWindow test3 = new SignUpWindow();
            test3.setBounds(700, 200, 500, 350);
            test3.getContentPane().setBackground(Color.BLACK);

            test3.setForeground(Color.WHITE);

        } else if (e.getActionCommand().equals("bottone3")) {

            SignUpWindow test3 = new SignUpWindow();
            test3.setBounds(700, 200, 500, 350);
            test3.getContentPane().setBackground(Color.BLACK);

            test3.setForeground(Color.WHITE);

        }
    }


    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
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

