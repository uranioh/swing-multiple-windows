����   = �  verifica/Accesso  javax/swing/JFrame  java/awt/event/ActionListener  java/awt/event/WindowListener placeholder I testo1 Ljavax/swing/JLabel; testo2 t1 Ljavax/swing/JTextField; t2 bottone1 Ljavax/swing/JButton; bottone2 bottone3 <init> ()V Code  (Verifica di informatica Casti Michele 4C
     (Ljava/lang/String;)V  javax/swing/JLabel   Username
  	  #   % Password	  '   ) javax/swing/JTextField
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
  � � � addWindowListener "(Ljava/awt/event/WindowListener;)V � java/awt/Font � Arial
 � �  � (Ljava/lang/String;II)V
  � � � setFont (Ljava/awt/Font;)V
 ( �
 N � � � add *(Ljava/awt/Component;)Ljava/awt/Component;
 I � LineNumberTable LocalVariableTable this Lverifica/Accesso; c Ljava/awt/Container; 	superiore Ljavax/swing/JPanel; 	inferiore actionPerformed (Ljava/awt/event/ActionEvent;)V
 � � � java/awt/event/ActionEvent � � getActionCommand ()Ljava/lang/String;
 � � � java/lang/String � � equals (Ljava/lang/Object;)Z
  +
  � � � 	setBounds (IIII)V
 I � � � setBackground (Ljava/awt/Color;)V	 b � � f WHITE
  � � � setForeground � verifica/Registrazione
 � +
 � �
 � @
 � � e Ljava/awt/event/ActionEvent; test2 test3 Lverifica/Registrazione; StackMapTable windowOpened (Ljava/awt/event/WindowEvent;)V Ljava/awt/event/WindowEvent; windowClosing � Sei sicuro di voler uscire? � messaggio importante
 � � � javax/swing/JOptionPane � � showConfirmDialog <(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
 � � � java/lang/System � { exit r windowClosed windowIconified windowDeiconified windowActivated windowDeactivated 
SourceFile Accesso.java !         	 
                                             	       }    �*� *� Y� !� "*� Y$� !� &*� (Y� *� ,*� (Y� *� .*� 0Y2� 4� 5*� 0Y7� 4� 9*� 0Y;� 4� =*� ?L+� CY+� E� H� NY� PM� NY� PN,



� Q� W,� [Y� ]� `-� a� g� W-� [Y� ]� `*� 5*� k*� 5o� p*� 9*� k*� 9s� p*� 9*� k*� =t� p*� u*� x*� |*� �**� �*� "� �Y�� �� �*� &� �Y�� �� �*� ,� �Y�
� �� �*� .� �Y�
� �� �,*� "� �W,*� ,� �W,*� &� �W,*� .� �W+,� �W-*� 5� �W-*� 9� �W-*� =� �W+-� �W�    �   � )   #        +  6  C  P   ] $ b & o ( w )  + � , � / � 0 � 3 � 4 � 5 � 6 � 7 � 8 � 9 � : � ; � < � = � ? @# A6 BI IR J[ Kd Mm Ns Q| R� S� V� [ �   *   � � �   b3 � �  w � �   � �   � �    G     �+� �o� �� /� Y� �M,� ��^� �,� ?� a� �,� �� �� p+� �s� �� /� �Y� �M,� ��^� �,� ² a� �,� �� ç 8+� �t� �� ,� �Y� �M,� ��^� �,� ² a� �,� �� ñ    �   J    b  d  e $ f . h 5 j 8 k D m L n \ o f q m s p t | v � w � x � z � } �   4    � � �     � � �   ! � �  L ! � �  � ! � �  �    874  � �     5      �    �       � �        � �      � �   � �     i     *��� �=� � ر    �       � 
 �  �  � �         � �      � �  
 	 � 
  �    �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   �    �