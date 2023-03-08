import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUpWindow extends JFrame implements ActionListener, WindowListener {
    //nome,cognome,sesso,provincia,città;

    String[] dati = {null, null, null, null, null};
    JLabel testo1 = new JLabel("Username");
    JLabel testo2 = new JLabel("Password");
    JLabel testo3 = new JLabel("Conferma Password");
    JLabel testo4 = new JLabel("Nome");
    JLabel testo5 = new JLabel("Cognome");
    JTextField num1 = new JTextField("");
    JTextField num2 = new JTextField("");
    JTextField num3 = new JTextField("");
    JTextField num4 = new JTextField("");
    JTextField num5 = new JTextField("");
    JButton bottone2 = new JButton("invio");
    JButton bottone3 = new JButton("Annulla");
    JRadioButton uno = new JRadioButton("maschio");
    JRadioButton due = new JRadioButton("femmina");

    JLabel testo6 = new JLabel("Provincia");
    String[] tre = {"Selargius", "Cagliari", "Villasor", "Domus de Maria", "Napoli"};
    JComboBox quattro = new JComboBox(tre);
    JLabel testo7 = new JLabel("Città");
    JTextField num6 = new JTextField("");

    public SignUpWindow() {
        super("Crea nuovo Account");

        Container c = this.getContentPane();

        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        JPanel superiore = new JPanel();
        JPanel inferiore = new JPanel();

        superiore.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        superiore.setLayout(new GridLayout(8, 2, 10, 10));
        superiore.setBackground(Color.GRAY);

        inferiore.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inferiore.setLayout(new GridLayout(2, 2));

        ButtonGroup bottoni = new ButtonGroup();
        bottoni.add(uno);
        bottoni.add(due);

        uno.setBackground(Color.GRAY);
        bottone2.addActionListener(this);
        bottone2.setActionCommand("bottone2");
        due.setBackground(Color.GRAY);
        due.addActionListener(this);
        due.setActionCommand("due");
        uno.addActionListener(this);
        uno.setActionCommand("uno");
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
        superiore.add(uno);
        superiore.add(due);
        superiore.add(testo6);
        superiore.add(quattro);
        superiore.add(testo7);
        superiore.add(num6);
        c.add(superiore);

        inferiore.add(bottone2);
        inferiore.add(bottone3);
        c.add(inferiore);


    }


    public void actionPerformed(ActionEvent e) {
        boolean errore = false;
        String InputSuFileStringa;
        if (e.getActionCommand().equals("bottone1")) {
//               if ( num1.()){
//               tastierino test4 = new tastierino();
//                   test4.setBounds(700, 200, 500, 350);
//                  test4.getContentPane().setBackground(Color.BLACK);
//             while(password<6){
//
//             }
//               }
            dati[1] = String.valueOf(Float.parseFloat(num1.getText()));
            dati[2] = String.valueOf(Float.parseFloat(num2.getText()));
            if (bottone2.isSelected()) {
                dati[3] = "maschio";
            } else
                dati[3] = "femmina";

            dati[4] = String.valueOf(Float.parseFloat(num1.getText()));
            dati[5] = String.valueOf(Float.parseFloat(num1.getText()));

//            scriviSuFile=new PrintWriter(new FileOutputStream(nomeFile,true));
//            for(int i=0;i<9;i++){
//                        inputSuFileStringa=inputSuFileStringa+" "+inputString[i];
//                         System.out.println(inputString[i]);
//            }
        }

        if (e.getActionCommand().equals("bottone2")) {
            System.exit(0);


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
            LoginWindow test2 = new LoginWindow();
            test2.setBounds(700, 200, 500, 350);
            test2.getContentPane().setBackground(Color.BLACK);

            test2.setForeground(Color.WHITE);
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


