/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package GUI;

import Classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game extends JFrame {
    //region Properties
    private Color backgroundColor = new Color(255, 22, 150);
    //Create Objects properties
    private static Font fontBigLabel = new Font("Algerian", Font.BOLD, 30);
    private static Font fontSmallLabel = new Font("Broadway", Font.BOLD, 20);
    private static Font fontRadio = new Font("Calibri", Font.BOLD, 20);
    private static Font fontTextArea = new Font ("Courier New",Font.BOLD, 16);
    private static ArrayList<Player> playerList = new ArrayList<>();//Array to store Player Objects
    private static ArrayList<Weapon> weaponList = new ArrayList<>(); //Array to store Weapon Objects

    //Indexes that user selected for Character and Weapon
    private static int characterSelectedIndex;
    private static int weaponSelectedIndex;
    private static String summaryCharacter; //String to display report for selected character.
    //endregion
    public Game() {
        //region General set-up for main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 5, 750, 750);
        setTitle("DND GAME");
        setLayout(new CardLayout());

        //Create 3 JPanels: splashScreen, characterCreationScreen, battleSummaryScreen
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.setBackground(backgroundColor);
        CharacterCreation characterCreationScreen = new CharacterCreation();
        characterCreationScreen.setBackground(backgroundColor);
        BattleSummary battleSummaryScreen = new BattleSummary();
        battleSummaryScreen.setBackground(backgroundColor);

        //Add JPanels  to main frame
        add(splashScreen);
        add(characterCreationScreen);
        add(battleSummaryScreen);
        //endregion

        //region Instantiate Objects
        //Instantiate Player Objects
        Warrior warrior = new Warrior(null, "Warrior", 12, 55, 65, 15, 10, "Fighters are often human. Have higher HP and defence but low agility");
        Wizard wizard = new Wizard(null, "Wizard", 30, 20, 25, 35, 12, "Wizards can do an awful lot of stuff - like see the future, hurl fire or animate teapots.");
        Cleric cleric= new Cleric(null, "Cleric", 280, 18, 55, 45, 18, "Clerics are versatile figures, both capable in combat and skilled in the use of divine magic");
        //Add players to Array playerList
        playerList.add(warrior);
        playerList.add(wizard);
        playerList.add(cleric);

        //Instantiate Weapon Objects
       Dagger dagger = new Dagger(13, 124, "A quick, lightweight melee weapon with a short blade, perfect for agile fighters valuing speed and precision in battle", 10);
       Sword sword = new Sword(58, 45, "A balanced melee weapon, offering a blend of speed and power.", 22);
       Hammer hammer = new Hammer(34, 245, "A hefty melee weapon renowned for its raw power, wielded by warriors who favor crushing blows over finesse in combat", 44);
        //Add weapons to Array weaponList
        weaponList.add(dagger);
        weaponList.add(sword);
        weaponList.add(hammer);
        //endregion

        //region Add event listener to Buttons
        //region Button Build Character
        JButton bntBuildCharacter = splashScreen.getBtnBuildCharacter();
        bntBuildCharacter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashScreen.setVisible(false);
                characterCreationScreen.setVisible(true);
            }
        });
        //endregion
        //region Button Start Battle
        JButton btnStartBattle = characterCreationScreen.getBtnStartBattle();
        btnStartBattle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Condition: User only can start battle when they have chosen their character and weapon
                if ((characterCreationScreen.getPlayerRdos().getSelection() != null) && (characterCreationScreen.getWeaponRdos().getSelection()!=null)){
                    //Call function createFinalCharacter to get the final selected choices of player and weapon from user
                    characterCreationScreen.createFinalCharacter();
                    //Set current screen to invisible
                    characterCreationScreen.setVisible(false);
                    //Set the next screen (battleSummary) visible
                    battleSummaryScreen.setVisible(true);
                    //Call function displayFinalReport from battleScreen to display report on screen.
                    battleSummaryScreen.displayFinalReport();
                }
                else {
                    //If user do not make required selection, then pop up an error message
                    JOptionPane.showMessageDialog(null, "Please input your name, then select a character and a weapon", "Wrong Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //endregion
        //region Button Start Again
        // User will jump to characterCreation screen to play the Game again.
        JButton btnPlayAgain = battleSummaryScreen.getBtnPlayAgain(); //get the playAgain Button from summary screen
        btnPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set the summary screen to invisible
                battleSummaryScreen.setVisible(false);
                //Reset for all textFields and textAreas in characterCreationScreen.
                characterCreationScreen.getTextCharName().setText("");
                characterCreationScreen.getTextCharDes().setText("");
                characterCreationScreen.getTextWeaponDes().setText("");
                characterCreationScreen.getImgCharacter().setIcon(null);
                characterCreationScreen.getImgCharacter().setText("Select a Class");
                characterCreationScreen.getImgWeapon().setIcon(null);
                characterCreationScreen.getImgWeapon().setText("Select a Weapon");

                //Reset for indicators of Character and Weapon in textFields
                for(int i=0; i<characterCreationScreen.getTextCharacterIndicatorList().size(); i++){
                    characterCreationScreen.getTextCharacterIndicatorList().get(i).setText("");
                }
                for(int i=0; i<characterCreationScreen.getTextWeaponIndicatorList().size(); i++){
                    characterCreationScreen.getTextWeaponIndicatorList().get(i).setText("");
                }
                //Reset selections for radio buttons
                characterCreationScreen.getPlayerRdos().clearSelection();
                characterCreationScreen.getWeaponRdos().clearSelection();

                //Set character creation screen visible
                characterCreationScreen.setVisible(true);
            }
        });
        //endregion
        //endregion

    }//close for Game()
    //region Getters/Setters
    public static int getCharacterSelectedIndex() {
        return characterSelectedIndex;
    }
    public static int getWeaponSelectedIndex() {
        return weaponSelectedIndex;
    }
    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }
    public static ArrayList<Weapon> getWeaponList() {
        return weaponList;
    }
    public static String getSummaryCharacter() {
        return summaryCharacter;
    }
    public static void setSummaryCharacter(String summaryCharacter) {
        Game.summaryCharacter = summaryCharacter;
    }
    public static void setCharacterSelectedIndex(int characterSelectedIndex) {
        Game.characterSelectedIndex = characterSelectedIndex;
    }
    public static void setWeaponSelectedIndex(int weaponSelectedIndex) {
        Game.weaponSelectedIndex = weaponSelectedIndex;
    }
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public static Font getFontBigLabel() {
        return fontBigLabel;
    }

    public static Font getFontSmallLabel() {
        return fontSmallLabel;
    }

    public static Font getFontRadio() {
        return fontRadio;
    }

    public static Font getFontTextArea() {
        return fontTextArea;
    }
    //endregion
}//Close for JFrame GAME


