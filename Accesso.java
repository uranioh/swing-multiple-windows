����   = �  verifica/Accesso  javax/swing/JFrame  java/awt/event/ActionListener  java/awt/event/WindowListener placeholder I testo1 Ljavax/swing/JLabel; testo2 t1 Ljavax/swing/JTextField; t2 bottone1 Ljavax/swing/JButton; bottone2 bottone3 <init> ()V Code  (Verifica di informatica Casti Michele 4C
     (Ljava/lang/String;)V  javax/swing/JLabel   Username
  	  #   % Password	  ' 
  ) javax/swing/JTextField
 ( +  	  -  	  /   1 javax/swing/JButton 3 indietro
 0 	  6   8 Invio	  :   < Annulla	  >  
  @ A B getContentPane ()Ljava/awt/Container; D javax/swing/BoxLayout
 C F  G (Ljava/awt/Container;I)V
 I K J java/awt/Container L M 	setLayout (Ljava/awt/LayoutManager;)V O javax/swing/JPanel
 N +
 R T S javax/swing/BorderFactory U V createEmptyBorder !(IIII)Ljavax/swing/border/Border;
 N X Y Z 	setBorder (Ljavax/swing/border/Border;)V \ java/awt/GridLayout
 [ ^  _ (II)V
 N K	 b d c java/awt/Color e f BLACK Ljava/awt/Color;
 R h i j createLineBorder -(Ljava/awt/Color;)Ljavax/swing/border/Border;
 0 l m n addActionListener "(Ljava/awt/event/ActionListener;)V 
 0 q r  setActionCommand  
  v w  pack
  y z { setDefaultCloseOperation (I)V
  } ~  
setVisible (Z)V
  � �  setResizable
  � � � addWindowListener "(Ljava/awt/event/WindowListener;)V � 
java/awt/Font � Arial
 � �  � (Ljava/lang/String;II)V
  � � � setFont (Ljava/awt/Font;)V
 ( �
 N � � � add *(Ljava/awt/Component;)Ljava/awt/Component;
 I � LineNumberTable LocalVariableTable this Lverifica/Accesso; c Ljava/awt/Container; 	superiore Ljavax/swing/JPanel; 	inferiore actionPerformed (Ljava/awt/event/ActionEvent;)V
 � � � java/awt/event/ActionEvent � � getActionCommand ()Ljava/lang/String;
 � � � java/lang/String � � equals (Ljava/lang/Object;)Z
  +
  � � � 	setBounds (IIII)V
 I � � � 
setBackground (Ljava/awt/Color;)V	 b � � f WHITE
  � � � 
setForeground � verifica/Registrazione
 � +
 � �
 � @
 � � e Ljava/awt/event/ActionEvent; test2 test3 Lverifica/Registrazione; 
StackMapTable windowOpened (Ljava/awt/event/WindowEvent;)V Ljava/awt/event/WindowEvent; 
windowClosing � Sei sicuro di voler uscire? � messaggio importante
 � � � javax/swing/JOptionPane � � showConfirmDialog <(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
 � � � java/lang/System � { exit r windowClosed windowIconified windowDeiconified windowActivated windowDeactivated 
SourceFile Accesso.java !         	 
           
                                  	       }    �*� *� Y� !� "*� Y$� !� &*� (Y� *� ,*� (Y� *� .*� 0Y2� 4� 5*� 0Y7� 4� 9*� 0Y;� 4� =*� ?L+� CY+� E� H� NY� PM� NY� PN,



� Q� W,� [Y� ]� `-� a� g� W-� [Y� ]� `*� 5*� k*� 5o� p*� 9*� k*� 9s� p*� 9*� k*� =t� p*� u*� x*� |*� �**� �*� "� �Y�� �� �*� &� �Y�� �� �*� ,� �Y�
� �� �*� .� �Y�
� �� �,*� "� �W,*� ,� �W,*� &� �W,*� .� �W+,� �W-*� 5� �W-*� 9� �W-*� =� �W+-� �W�    �   � )   #        +  6  C  P   ] $ b & o ( w )  + � , � / � 0 � 3 � 4 � 5 � 6 � 7 � 8 � 9 � : � ; � < � = � ? @# A6 BI IR J[ Kd Mm Ns Q| R� S� V� [ �   *   � � �   b3 � �  w � �   � �   � �    G     �+� �o� �� /� Y� �M,� ��^� �,� ?� a� �,� �� �� p+� �s� �� /� �Y� �M,� ��^� �,� ² a� �,� �� ç 8+� �t� �� ,� �Y� �M,� ��^� �,� ² a� �,� �� ñ    �   J    b  d  e $ f . h 5 j 8 k D m L n \ o f q m s p t | v � w � x � z � } �   4    � � �     � � �   ! � �  L ! � �  � ! � �  �    874  � �     5      �    �       � �        � �      � �   � �     i     *��� �=� � ر    �       � 
 �  �  � �         � �      � �  
 	 � 
  �    �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   �    �package verifica;

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


public class Accesso extends JFrame implements ActionListener, WindowListener {
    int placeholder;
    JLabel testo1 = new JLabel("Username");
    JLabel testo2 = new JLabel("Password");
    JTextField t1= new JTextField();
    JTextField t2= new JTextField();
    JButton bottone1 = new JButton("indietro");
    JButton bottone2 = new JButton("Invio");
    JButton bottone3 = new JButton("Annulla");

    public Accesso() {
        super("Verifica di informatica Casti Michele 4C");
        Container c = this.getContentPane();

        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        JPanel superiore = new JPanel();
        JPanel inferiore = new JPanel();

        superiore.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        superiore.setLayout(new GridLayout(2,1));


        inferiore.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inferiore.setLayout(new GridLayout(1,3));


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


        inferiore.add(bottone1);
        inferiore.add(bottone2);
        inferiore.add(bottone3);


        c.add(inferiore);




    }




    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals("bottone1")) {

            Accesso test2 = new Accesso();
            test2.setBounds(700, 200, 500, 350);
            test2.getContentPane().setBackground(Color.BLACK);

            test2.setForeground(Color.WHITE);

        }
        else if(e.getActionCommand().equals("bottone2")) {

            Registrazione test3 = new Registrazione();
            test3.setBounds(700, 200, 500, 350);
            test3.getContentPane().setBackground(Color.BLACK);

            test3.setForeground(Color.WHITE);

        }
        else if(e.getActionCommand().equals("bottone3")) {

            Registrazione test3 = new Registrazione();
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

