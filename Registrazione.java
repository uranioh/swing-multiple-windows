����   =  verifica/Registrazione  javax/swing/JFrame  java/awt/event/ActionListener  java/awt/event/WindowListener numeri [I x I placeholder testo1 Ljavax/swing/JLabel; testo2 testo3 testo4 testo5 num1 Ljavax/swing/JTextField; num2 num3 num4 num5 bottone1 Ljavax/swing/JButton; bottone2 <init> ()V Code ! Crea nuovo Account
  #  $ (Ljava/lang/String;)V	  & 	 
	  (   * javax/swing/JLabel , Prima Stringa
 ) #	  /   1 Seconda Stringa	  3   5 Terza Stringa	  7   9 Quarta Stringa	  ;   = Quinta Stringa	  ?   A javax/swing/JTextField C  
 @ #	  F  	  H  	  J  	  L  	  N   P javax/swing/JButton R Accedi
 O #	  U   W 
Registrati	  Y  
  [ \ ] getContentPane ()Ljava/awt/Container; _ javax/swing/BoxLayout
 ^ a  b (Ljava/awt/Container;I)V
 d f e java/awt/Container g h 	setLayout (Ljava/awt/LayoutManager;)V j javax/swing/JPanel
 i l  
 n p o javax/swing/BorderFactory q r createEmptyBorder !(IIII)Ljavax/swing/border/Border;
 i t u v 	setBorder (Ljavax/swing/border/Border;)V x java/awt/GridLayout
 w z  { (IIII)V
 i f	 ~ �  java/awt/Color � � GRAY Ljava/awt/Color;
 i � � � setBackground (Ljava/awt/Color;)V	 ~ � � � BLACK
 n � � � createLineBorder -(Ljava/awt/Color;)Ljavax/swing/border/Border;
 w �  � (II)V
 O � � � addActionListener "(Ljava/awt/event/ActionListener;)V 
 O � � $ setActionCommand 
  � �  pack
  � � � setDefaultCloseOperation (I)V
  � � � 
setVisible (Z)V
  � � � setResizable
  � � � addWindowListener "(Ljava/awt/event/WindowListener;)V � java/awt/Font � Arial
 � �  � (Ljava/lang/String;II)V
 ) � � � setFont (Ljava/awt/Font;)V
 i � � � add *(Ljava/awt/Component;)Ljava/awt/Component;
 d � LineNumberTable LocalVariableTable this Lverifica/Registrazione; c Ljava/awt/Container; 	superiore Ljavax/swing/JPanel; 	inferiore actionPerformed (Ljava/awt/event/ActionEvent;)V
 � � � java/awt/event/ActionEvent � � getActionCommand ()Ljava/lang/String;
 � � � java/lang/String � � equals (Ljava/lang/Object;)Z
 � � � java/lang/System � � exit � verifica/Accesso
 � l
 � � � { 	setBounds
 � [
 d �	 ~ � � � WHITE
 � � � � setForeground e Ljava/awt/event/ActionEvent; test2 Lverifica/Accesso; StackMapTable windowOpened (Ljava/awt/event/WindowEvent;)V Ljava/awt/event/WindowEvent; windowClosing � Sei sicuro di voler uscire? � messaggio importante
 � � � javax/swing/JOptionPane � � showConfirmDialog <(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I r windowClosed windowIconified windowDeiconified windowActivated windowDeactivated 
SourceFile Registrazione.java !        	 
                                                                                       	       �    �* � "*�
� %*� '*� )Y+� -� .*� )Y0� -� 2*� )Y4� -� 6*� )Y8� -� :*� )Y<� -� >*� @YB� D� E*� @YB� D� G*� @YB� D� I*� @YB� D� K*� @YB� D� M*� OYQ� S� T*� OYV� S� X*� ZL+� ^Y+� `� c� iY� kM� iY� kN,



� m� s,� wY� y� |,� }� �-� �� �� s-� wY� �� |*� T*� �*� T�� �*� X*� �*� X�� �*� �*� �*� �*� �**� �*� .� �Y�� �� �*� 2� �Y�� �� �,*� .� �W,*� E� �W,*� 2� �W,*� G� �W,*� 6� �W,*� I� �W,*� :� �W,*� K� �W,*� >� �W,*� M� �W+,� �W-*� T� �W-*� X� �W+-� �W�    �   � 2   +         ,  9  F   S ! ` " m # z $ � % � & � ' � , � . � 0 � 1 � 3 � 4 � 5 � 7 8 ; < =' >0 @4 A9 B> CC DH F[ Gn Qw R� S� T� U� V� W� X� Y� Z� [� ^� _� c� h �   *   � � �   �4 � �  � � �  � � �   � �     �     :+� ��� ͙ 0� ӻ �Y� �M,� ��^� �,� ޲ �� �,� � �    �       o  p  q  r ( s 2 u 9 x �        : � �     : � �   ! � �  �    9  � �     5      �    �       � �        � �      � �   � �     i     *��� �=� � ӱ    �       � 
 �  �  � �         � �      � �  
 	 �   �    �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   � �     5      �    �       � �        � �      � �   �    