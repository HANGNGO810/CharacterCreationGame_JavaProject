/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SplashScreen extends JPanel {
    //region Properties
    private JLabel imageLabel;//image of the Game
    private JButton btnBuildCharacter; //Button Build Character
    private JTextArea textGameRules;//Area to display the Game rules
    //endregion
    //region Method
    public SplashScreen(){
        //Display name of the Game
        JLabel nameLabel = new JLabel("Dragon and Dungeons");
        nameLabel.setFont(new Font("Algerian", Font.BOLD, 45));
        nameLabel.setBounds(250, 10, 200, 50);

        //Image of the screen
        imageLabel = new JLabel();
        imageLabel.setBounds(10, 80, 750, 375);
        imageLabel.setIcon(new ImageIcon(this.getClass().getResource("ImagesGUI//splashScreenImg.jpg")));

        //TextArea for Game's rules
        textGameRules = new JTextArea();
        textGameRules.setBounds(250, 470, 530, 350);
        Font textAreaFont = new Font ("Courier New",Font.PLAIN, 16);
        textGameRules.setFont(Game.getFontTextArea());
        textGameRules.setLineWrap(true);
        textGameRules.setEnabled(false);
        textGameRules.setWrapStyleWord(true);
        textGameRules.setBackground(Color.pink);
        textGameRules.setDisabledTextColor(Color.black);
        textGameRules.setMargin(new Insets(10, 10, 10, 10));
        textGameRules.setText("Welcome to the Dragon and Dungeons Game!\n" +
                "\n" +
                "To begin, please enter your name. Afterward, select a character and a weapon to initiate a battle. " +
                "Remember! you must choose character and weapon to be able to start a battle.\n" +
                "\n" +
                "To improve your chances, select a character before hitting the REROLL button for better options. \n\t\t\tHAVE FUN!!!");

        //Button BuildCharacter
        btnBuildCharacter = new JButton("Build A Character");
        btnBuildCharacter.setFont(Game.getFontSmallLabel());
        btnBuildCharacter.setBounds(250, 560, 100, 30);

        //Add content to the frame JLabel
      add(nameLabel);
      add(imageLabel);
      add(textGameRules);
      add(btnBuildCharacter);

    }
    //endregion
    //region Getters/Setters
    public JButton getBtnBuildCharacter() {
        return btnBuildCharacter;
    }
    public JLabel getImageLabel() {
        return imageLabel;
    }
    public JTextArea getTextGameRules() {
        return textGameRules;
    }
    //endregion
}
