import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        set the look and feel API to WinUI or GTK based on the OS
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
    }

}