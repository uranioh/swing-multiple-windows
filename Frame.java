����   = �  verifica/Frame  javax/swing/JFrame  java/awt/event/ActionListener  java/awt/event/WindowListener placeholder I testo1 Ljavax/swing/JLabel; testo2 bottone1 Ljavax/swing/JButton; bottone2 <init> ()V Code  (Verifica di informatica Casti Michele 4C
     (Ljava/lang/String;)V  javax/swing/JLabel  'Premi 'Accedi' per effettuare il login 
  	     ! ,'Registrati' per effettuare la registrazione	  #   % javax/swing/JButton ' Accedi
 $ 	  *   , 
Registrati	  .  
  0 1 2 getContentPane ()Ljava/awt/Container; 4 javax/swing/BoxLayout
 3 6  7 (Ljava/awt/Container;I)V
 9 ; : java/awt/Container < = 	setLayout (Ljava/awt/LayoutManager;)V ? javax/swing/JPanel
 > A  
 C E D javax/swing/BorderFactory F G createEmptyBorder !(IIII)Ljavax/swing/border/Border;
 > I J K 	setBorder (Ljavax/swing/border/Border;)V M java/awt/GridLayout
 L O  P (II)V
 > ;	 S U T java/awt/Color V W CYAN Ljava/awt/Color;
 > Y Z [ setBackground (Ljava/awt/Color;)V	 S ] ^ W BLACK
 C ` a b createLineBorder -(Ljava/awt/Color;)Ljavax/swing/border/Border;
 $ d e f addActionListener "(Ljava/awt/event/ActionListener;)V 
 $ i j  setActionCommand 
  m n  pack
  p q r setDefaultCloseOperation (I)V
  t u v 
setVisible (Z)V
  x y v setResizable
  { | } addWindowListener "(Ljava/awt/event/WindowListener;)V  java/awt/Font � Arial
 ~ �  � (Ljava/lang/String;II)V
  � � � setFont (Ljava/awt/Font;)V
  Y
  � � v 	setOpaque
 > � � � add *(Ljava/awt/Component;)Ljava/awt/Component;
 9 � LineNumberTable LocalVariableTable this Lverifica/Frame; c Ljava/awt/Container; 	superiore Ljavax/swing/JPanel; 	inferiore actionPerformed (Ljava/awt/event/ActionEvent;)V
 � � � java/awt/event/ActionEvent � � getActionCommand ()Ljava/lang/String;
 � � � java/lang/String � � equals (Ljava/lang/Object;)Z � verifica/Accesso
 � A
 � � � � 	setBounds (IIII)V
 � 0
 9 Y	 S � � W WHITE
 � � � [ setForeground � verifica/Registrazione
 � A
 � �
 � 0
 � � e Ljava/awt/event/ActionEvent; test2 Lverifica/Accesso; test3 Lverifica/Registrazione; StackMapTable windowOpened (Ljava/awt/event/WindowEvent;)V Ljava/awt/event/WindowEvent; windowClosing � Sei sicuro di voler uscire? � messaggio importante
 � � � javax/swing/JOptionPane � � showConfirmDialog <(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
 � � � java/lang/System � r exit r windowClosed windowIconified windowDeiconified windowActivated windowDeactivated 
SourceFile 
Frame.java !         	 
                           	           K*� *� Y� � *� Y � � "*� $Y&� (� )*� $Y+� (� -*� /L+� 3Y+� 5� 8� >Y� @M� >Y� @N,



� B� H,� LY� N� Q,� R� X-� \� _� H-� LY� N� Q*� )*� c*� )g� h*� -*� c*� -k� h*� l*� o*� s*� w**� z*� � ~Y�� �� �*� � R� �*� � �*� "� ~Y�� �� �*� "� �*� "� R� �,*� � �W,*� "� �W+,� �W-*� )� �W-*� -� �W+-� �W�    �   � $   $        -   : % ? ' L ) T * \ , k - x .  0 � 1 � 4 � 5 � 6 � 7 � 9 � : � ; � < � = � ? � @ � A � B C D M# N, P2 S; TD XJ ] �   *   K � �   ? � �  T � � �  \ � � �   � �     �     x+� �g� �� 4*� o� �Y� �M,� ��^� �,� �� \� �,� �� �� =+� �k� �� 1*� o� �Y� �M,� �X¶ �,� �� \� �,� �� ��    �   :    d  e  f  g ) h 3 j : l = m I n N o V p f q p s w v �   *    x � �     x � �   ! � �  V ! � �  �    =9  � �     5      �    �       � �        � �      � �   � �     i     *��� �=� � ӱ    �       � 
 �  �  � �         � �      � �  
 	 � 
  �    �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   �    �