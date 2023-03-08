
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    public class scemo extends JFrame implements ActionListener, WindowListener {
        int placeholder;
        JLabel test1 = new JLabel("inserisci tutti i dati.Registrazione fallita.");
        JButton scemino=new JButton("OK");

        public scemo() {
            super("Verifica di informatica Casti Michele 4C");
            Container c = this.getContentPane();

            c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
            JPanel superiore = new JPanel();
            JPanel inferiore = new JPanel();
            superiore.setLayout(new GridLayout(1, 1));
            inferiore.setLayout(new GridLayout(1, 1));
            superiore.add(test1);
            scemino.setBackground(Color.GRAY);
            scemino.addActionListener(this);

            inferiore.add(scemino);
            c.add(superiore);
            c.add(inferiore);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("scemino")){
                System.exit(0);
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


