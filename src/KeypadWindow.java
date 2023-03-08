
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeypadWindow extends JFrame implements ActionListener, WindowListener {
    int password = 0;
    String truepassword = "12345678910";
    String[] cancella = {null, null, null, null, null, null, null, null, null, null, null};
    String s;
    JButton[] x = new JButton[11];


    public KeypadWindow() {
        super("odio java");
        Container c = this.getContentPane();

        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        JPanel superiore = new JPanel();
        JPanel inferiore = new JPanel();
        superiore.setLayout(new GridLayout(3, 3));
        c.setBackground(Color.GRAY);
        inferiore.setLayout(new GridLayout(1, 3));
        c.add(inferiore);
        for (int y = 1; y < 13; y++) {
            if (y == 10) {
                x[y].setText("0");
                x[y].addActionListener(this);
                inferiore.add(x[y]);
            }
            if (y == 11) {
                x[y].setText("X");
                x[y].addActionListener(this);
                inferiore.add(x[y]);
            } else if (y == 12) {
                x[y].setText("DEL");
                x[y].addActionListener(this);
                inferiore.add(x[y]);
            } else
                s = "" + y + "";
            x[y].addActionListener(this);
            x[y].setText(s);
        }


        c.add(superiore);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num;
        boolean uguale = false;
        boolean canc = false;
        int y = 10;
        int i = 0;
        String placeholder = "";
        while (uguale == false) {


            while (password < 10) {
                if (e.getActionCommand().equals(s)) {
                    if (s == "X") {
                        while (canc == false)
                            if (cancella[y] == "null") {
                                y--;
                            } else
                                cancella[y] = null;
                        canc = true;
                    } else if (s == "DEL") {
                        placeholder = null;
                    }
                    cancella[password] = s;
                    placeholder = placeholder + x[password];
                    password++;

                }

            }
            if (placeholder == truepassword) {
                uguale = true;
            }
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