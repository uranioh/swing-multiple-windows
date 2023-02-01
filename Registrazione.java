import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Registrazione extends JFrame implements ActionListener, WindowListener {
    public int[] numeri = {0, 0, 0, 0, 0};
    int x = 5;
    int placeholder;
    JLabel testo1 = new JLabel("Prima Stringa");
    JLabel testo2 = new JLabel("Seconda Stringa");
    JLabel testo3 = new JLabel("Terza Stringa");
    JLabel testo4 = new JLabel("Quarta Stringa");
    JLabel testo5 = new JLabel("Quinta Stringa");
    JTextField num1 = new JTextField("");
    JTextField num2 = new JTextField("");
    JTextField num3 = new JTextField("");
    JTextField num4 = new JTextField("");
    JTextField num5 = new JTextField("");
    JButton bottone1 = new JButton("Accedi");
    JButton bottone2 = new JButton("Registrati");


    public Registrazione() {
        super("Crea nuovo Account");
        Container c = this.getContentPane();

        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        JPanel superiore = new JPanel();
        JPanel inferiore = new JPanel();

        superiore.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        superiore.setLayout(new GridLayout(5, 2, 20, 20));
        superiore.setBackground(Color.GRAY);

        inferiore.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inferiore.setLayout(new GridLayout(2, 1));


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
        testo2.setFont(new Font("Arial", Font.BOLD, 16));


        superiore.add(testo1);
        superiore.add(num1);
        superiore.add(testo2);
        superiore.add(num2);
        superiore.add(testo3);
        superiore.add(num3);
        superiore.add(testo4);
        superiore.add(num4);
        superiore.add(testo5);
        superiore.add(num5);
        c.add(superiore);


        inferiore.add(bottone1);
        inferiore.add(bottone2);


        c.add(inferiore);


    }


    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("bottone1")) {
            System.exit(0);
            Accesso test2 = new Accesso();
            test2.setBounds(700, 200, 500, 350);
            test2.getContentPane().setBackground(Color.BLACK);

            test2.setForeground(Color.WHITE);

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


