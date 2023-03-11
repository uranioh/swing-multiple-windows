import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Label.font", new Font("Dialog", Font.PLAIN, 12));
            UIManager.put("Button.font", new Font("Dialog", Font.PLAIN, 12));
            UIManager.put("TextField.font", new Font("Dialog", Font.PLAIN, 12));

        } catch (Exception e) {
            e.printStackTrace();
        }

        MainWindow w = new MainWindow();
        w.setBounds(200, 200, 500, 350);
        w.getContentPane().setBackground(Color.BLACK);

        w.setForeground(Color.WHITE);

    }

}