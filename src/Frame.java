import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener, WindowListener {

    int placeholder;
    JLabel testo1 = new JLabel("Premi 'Accedi' per effettuare il login ");
    JLabel testo2 = new JLabel("'Registrati' per effettuare la registrazione");


    JButton bottone1 = new JButton("Accedi");
    JButton bottone2 = new JButton("Registrati");


    public Frame() {
        super("Verifica di informatica Casti Michele 4C");
        Container c = this.getContentPane();

        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        JPanel superiore = new JPanel();
        JPanel inferiore = new JPanel();

        superiore.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        superiore.setLayout(new GridLayout(2, 1));
        superiore.setBackground(Color.CYAN);

        inferiore.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inferiore.setLayout(new GridLayout(1, 2));


        bottone1.addActionListener(this);
        bottone1.setActionCommand("bottone1");
        bottone2.addActionListener(this);
        bottone2.setActionCommand("bottone2");

        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.addWindowListener(this);

        testo1.setFont(new Font("Arial", Font.BOLD, 16));
        testo1.setBackground(Color.CYAN);
        testo1.setOpaque(true);
        testo2.setFont(new Font("Arial", Font.BOLD, 16));
        testo2.setOpaque(true);
        testo2.setBackground(Color.CYAN);


        superiore.add(testo1);
        superiore.add(testo2);

        c.add(superiore);


        inferiore.add(bottone1);
        inferiore.add(bottone2);


        c.add(inferiore);


    }


    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("bottone1")) {
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            Accesso test2 = new Accesso();
            test2.setBounds(700, 200, 500, 350);
            test2.getContentPane().setBackground(Color.BLACK);

            test2.setForeground(Color.WHITE);

        } else if (e.getActionCommand().equals("bottone2")) {
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            Registrazione test3 = new Registrazione();
            test3.setBounds(700, 200, 600, 450);
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