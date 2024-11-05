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
import java.lang.reflect.Array;
import java.util.ArrayList;
import static java.lang.String.valueOf;
public class CharacterCreation extends JPanel {
    //region PROPERTIES
    //Player properties
    private JTextField textCharName;
    private ArrayList<JRadioButton>rdoPlayerList = new ArrayList<>(); //Array list of radio buttons in character area
    private ButtonGroup playerRdos; //button group of player radios
    private ArrayList<JTextField> textCharacterIndicatorList = new ArrayList<>(); //Array list JTextFiled of Character Indicators
    private JTextArea textCharDes; //Description of character
    private  JLabel imgCharacter; // Image of Character

    //Weapon properties
    private ArrayList<JRadioButton>rdoWeaponList = new ArrayList<>(); //Array list of radio buttons in weapon area
    private ButtonGroup weaponRdos; //button group of weapon radios
    private ArrayList<JTextField> textWeaponIndicatorList = new ArrayList<>(); //Array list JTextFiled of Weapon Indicators
    private JTextArea textWeaponDes; //Description of Weapon
    private JLabel imgWeapon;// Image of Weapon

    //Buttons
    private JButton btnStartBattle; //Button Start Battle
    private JButton btnReroll;//Button Reroll
    //endregion

    //region Method CharacterCreation()
    public CharacterCreation() {
        //region General set up for the panel
        //Set Panel Properties
        setLayout(null);
        setVisible(true);

        //Set the fonts
        Font nameTextFont = Game.getFontBigLabel();
        Font characterTextFont = Game.getFontSmallLabel();
        Font radioFont = Game.getFontRadio();
        Font textAreaFont = Game.getFontTextArea();

        //Display name of this frame
        JLabel label1 = new JLabel("Character Generator");
        label1.setFont(nameTextFont);
        label1.setBounds(200, 10, 450, 40);

        //Area for user enter character Name
        JLabel label2 = new JLabel("Enter Name");
        label2.setFont(characterTextFont);
        label2.setBounds(50, 60, 200, 20);
        textCharName = new JTextField();
        textCharName.setFont(characterTextFont);
        textCharName.setBounds(250, 60, 200, 35);

        //PLAYER AREA
        JLabel labelChar = new JLabel("Character Type");
        labelChar.setFont(characterTextFont);
        labelChar.setBounds(50, 70, 270, 100);

        //Player description area
        textCharDes = new JTextArea();
        textCharDes.setBounds(50, 308, 335, 80);
        textCharDes.setFont(textAreaFont);
        textCharDes.setLineWrap(true);
        textCharDes.setEnabled(false);
        textCharDes.setWrapStyleWord(true);
        textCharDes.setSelectedTextColor(Color.black);

        //WEAPON AREA
        JLabel weaponLabel = new JLabel("Select your Weapon");
        weaponLabel.setFont(characterTextFont);
        weaponLabel.setBounds(50, 390, 350, 50);
        //Weapon description area
        textWeaponDes = new JTextArea();
        textWeaponDes.setBounds(50, 600, 335, 80);
        textWeaponDes.setFont(textAreaFont);
        textWeaponDes.setLineWrap(true);
        textWeaponDes.setEnabled(false);
        textWeaponDes.setWrapStyleWord(true);
        textWeaponDes.setSelectedTextColor(Color.black);

        //IMAGE AREA FOR CHARACTER
        imgCharacter = new JLabel("Select a class");
        imgCharacter.setBounds(210, 150, 220, 150);

        //IMAGE AREA FOR WEAPON
        imgWeapon = new JLabel("Select a weapon");
        imgWeapon.setBounds(210, 430, 220, 150);

        //STATISTICS AREA
        JLabel label3 = new JLabel("Character Stats");
        label3.setFont(characterTextFont);
        label3.setBounds(500, 70, 270, 100);

        JLabel label4 = new JLabel("Weapon Stats");
        label4.setFont(characterTextFont);
        label4.setBounds(500, 370, 270, 100);

        //REROLL BUTTON
        btnReroll = new JButton("Reroll");
        btnReroll.setFont(characterTextFont);
        btnReroll.setBounds(510, 300, 130, 25);

        //STARTBATTLE BUTTON
        btnStartBattle = new JButton("Start Battle");
        btnStartBattle.setFont(characterTextFont);
        btnStartBattle.setBounds(510, 585, 185, 35);

        //Add to the Frame:
        add(label1);
        add(label2);
        add(textCharName);
        add(labelChar);
        add(textCharDes);
        add(weaponLabel);
        add(textWeaponDes);
        add(label3);
        add(label4);
        add(btnReroll);
        add(btnStartBattle);

        add(imgCharacter);
        add(imgWeapon);

        //Call method to create radio buttons
        generatePlayers(radioFont);
       // charStats(radioFont);
        generateWeapons(radioFont);
        //endregion
        //region Button Reroll: add event listener
        //user choose ReRoll button to generate random numbers for character indicators
        btnReroll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerRdos.getSelection()!=null) {
                    //Create random numbers for indicators
                    int randomHitPoint = (int) (20 + Math.random() * 500);
                    int randomDefense = (int) (20 + Math.random() * 130);
                    int randomAgility = (int) (10 + Math.random() * 110);
                    int randomBaseAttack = (int) (20 + Math.random() * 80);
                    //Instantiate selected Player object
                    Player player = Game.getPlayerList().get(Game.getCharacterSelectedIndex());
                    //Set new rerolled indicators to selected player
                    player.setHitPoints(randomHitPoint);
                    player.setDefense(randomDefense);
                    player.setAgility(randomAgility);
                    player.setBaseAttack(randomBaseAttack);
                    //Display rerolled indicators to corresponding text area
                    textCharacterIndicatorList.getFirst().setText(String.valueOf(randomHitPoint));
                    textCharacterIndicatorList.get(1).setText(String.valueOf(randomDefense));
                    textCharacterIndicatorList.get(2).setText(String.valueOf(randomAgility));
                    textCharacterIndicatorList.get(3).setText(String.valueOf(randomBaseAttack));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please choose a character first", "Wrong Input", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        //endregion
    }
    //endregion

//------------------------------------------CHARACTER AREAS-------------------------------------------------------------
private void generatePlayers(Font rdoFont){
    //region Area for textfields to display character's indicators
    //variables to store position y
    int yPos1 = 150;
    int yPos2= 150;
    //String array characterIndicators is to store name of character's indicators
    String [] characterIndicators = {"Hit Points", "Defense", "Agility", "Base Attack"};
    //Instantiate 4 JTextField for character indicators
    JTextField hitPointText = new JTextField();
    JTextField defenseText = new JTextField();
    JTextField agilityText = new JTextField();
    JTextField baseAttackText = new JTextField();
    //Add objects to the array list
    textCharacterIndicatorList.add(hitPointText);
    textCharacterIndicatorList.add(defenseText);
    textCharacterIndicatorList.add(agilityText);
    textCharacterIndicatorList.add(baseAttackText);
    //Loop through the textFiled list
    for(int i=0; i<textCharacterIndicatorList.size(); i++){
        //Generate label for each field
        JLabel label = new JLabel(characterIndicators[i]);
        label.setBounds(500, yPos1, 100, 30);
        label.setFont(rdoFont);
        this.add(label);
        yPos1+=35;//increase position y
        //Generate textFields corresponding with labels
        JTextField currentTextField = textCharacterIndicatorList.get(i);
        currentTextField.setFont(rdoFont);
        currentTextField.setBounds(635, yPos2, 50, 30);
        currentTextField.setEnabled(false);
        currentTextField.setSelectedTextColor(Color.black);
        this.add(currentTextField);
        yPos2+=35;//increase position y
    }
    //endregion
    //region Area for Character's radio buttons
    int yPos = 150; //variable to store position y
    //Instantiate Group of radio buttons
    playerRdos = new ButtonGroup();
    //String array to store Player's Types
    String [] playerTypes = {"Warrior", "Wizard", "Cleric"};
    //Instantiate RadioButton objects
    JRadioButton rdoWarrior = new JRadioButton();
    JRadioButton rdoWizard = new JRadioButton();
    JRadioButton rdoCleric = new JRadioButton();
    //Add radio buttons to the arrayList - rdoPlayerList
    rdoPlayerList.add(rdoWarrior);
    rdoPlayerList.add(rdoWizard);
    rdoPlayerList.add(rdoCleric);
    //Loop through the list of radio buttons
    for(int i = 0; i<rdoPlayerList.size(); i++){
        //Get the current radio and set its properties
        JRadioButton currentRdo = rdoPlayerList.get(i);
        currentRdo.setText(playerTypes[i]);
        currentRdo.setBackground(null);
        currentRdo.setFont(rdoFont);
        currentRdo.setBounds(50, yPos, 150, 30);
        //Add current radio to the frame
        add(currentRdo);
        //Add current radio to arrayList playerRdos
        playerRdos.add(currentRdo);
        yPos+=35; //increase position y

        //Add event listener to current radio button
        int finalI = i;//Index to save selected player
        currentRdo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Check which radio button is selected by user
                // Instantiate the corresponded Object and call method to generate selected player's statistic
                if (rdoWarrior.isSelected())
                {
                    Warrior warrior = (Warrior) Game.getPlayerList().getFirst();
                    generatePlayStats(warrior);
                    imgCharacter.setText(""); //replaced text "Select a Class" by "" (to display only character's image in this area)
                    }
                else if (rdoWizard.isSelected())
                {
                    Wizard wizard = (Wizard) Game.getPlayerList().get(1);
                    generatePlayStats(wizard);
                    imgCharacter.setText("");
                    }
                else {
                    Cleric cleric = (Cleric) Game.getPlayerList().get(2);
                    generatePlayStats(cleric);
                    imgCharacter.setText("");
                }
                //Set selected index of current character to index i
                Game.setCharacterSelectedIndex(finalI);
            }
        });
    }//close For...loop
    //endregion
}//CLOSE for method generatePlayers

    //region Method to Generate Player Statistics
    public void generatePlayStats(Player player){
    //Set text for indicators: hitPoints, defense, agility, baseAttack
    textCharacterIndicatorList.getFirst().setText(String.valueOf(player.getHitPoints()));
    textCharacterIndicatorList.get(1).setText(String.valueOf(player.getDefense()));
    textCharacterIndicatorList.get(2).setText(String.valueOf(player.getAgility()));
    textCharacterIndicatorList.get(3).setText(String.valueOf(player.getBaseAttack()));
    textCharDes.setText(player.getDescription());
    //set Image for player
    imgCharacter.setIcon(player.getImage());
    }
    //endregion

    //--------------------------------------WEAPON AREAS----------------------------------------------------------------
    public void generateWeapons(Font weapFont){
    //region Area for textfields to display Weapon's indicators
        //Variables to store position y
        int yPos1 = 450;
        int yPos2= 450;
        //String array to store name of weapon's indicators
        String [] weaponIndicators = {"Attack Modifier", "Weight"};
        //Instantiate text field objects
        JTextField attackModText = new JTextField();
        JTextField weightText = new JTextField();
        //Add objects to the arrayList
        textWeaponIndicatorList.add(attackModText);
        textWeaponIndicatorList.add(weightText);
        //Loop through the text field arrayList
        for(int i=0; i<textWeaponIndicatorList.size(); i++) {
            //Generate label and properties for each field
            JLabel label = new JLabel(weaponIndicators[i]);
            label.setBounds(500, yPos1, 200, 30);
            label.setFont(weapFont);
            this.add(label);
            yPos1 += 35; //increase position y

            //Generate textField corresponding with labels
            JTextField currentWeapTextFiled = textWeaponIndicatorList.get(i);
            currentWeapTextFiled.setFont(weapFont);
            currentWeapTextFiled.setBounds(635, yPos2, 50, 30);
            currentWeapTextFiled.setEnabled(false);
            currentWeapTextFiled.setSelectedTextColor(Color.black);
            //Add text field to the Frame
            add(currentWeapTextFiled);
            yPos2 += 35;//increase position y
        }
    //endregion
    //region Area for Weapon's radio buttons
        int yPos3= 450;
        //Declare Group of radios
        weaponRdos = new ButtonGroup();
        //String array to store label for radio buttons
        String [] weaponTypes = {"Dagger", "Sword", "Hammer"};
        //Create weapon radio buttons
        JRadioButton rdoDagger = new JRadioButton();
        JRadioButton rdoSword = new JRadioButton();
        JRadioButton rdoHammer = new JRadioButton();
        //Add radios to ArrayList: rdoWeaponList
        rdoWeaponList.add(rdoDagger);
        rdoWeaponList.add(rdoSword);
        rdoWeaponList.add(rdoHammer);
        //Loop through a list of radio buttons and set their properties
        for(int i = 0; i<rdoWeaponList.size(); i++){
            //Create list of radio buttons
            JRadioButton currentRdo = rdoWeaponList.get(i);
            currentRdo.setText(weaponTypes[i]);
            currentRdo.setBackground(null);
            currentRdo.setFont(weapFont);
            currentRdo.setBounds(50, yPos3, 150, 30);
            //add current radio button to the frame
            add(currentRdo);
           //Add current radio button to the group of radios
            weaponRdos.add(currentRdo);
            yPos3+=35;

            //Add action listeners to radio buttons
            int finalI = i; //Selected index of current weapon
            currentRdo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Checking which radio button is selected then instantiate the corresponding object
                    // And Call function generateWeaponStats of that object.
                    if (rdoDagger.isSelected())
                    {
                        Dagger dagger = (Dagger) Game.getWeaponList().getFirst();
                        generateWeaponStats(dagger);
                        imgWeapon.setText("");//replaced text "Select a Weapon" by "" (to display only weapon's image in this area)
                    }
                    else if (rdoSword.isSelected())
                    {
                        Sword sword = (Sword) Game.getWeaponList().get(1);
                        generateWeaponStats(sword);
                        imgWeapon.setText("");
                    }
                    else {
                        Hammer hammer = (Hammer) Game.getWeaponList().get(2);
                        generateWeaponStats(hammer);
                        imgWeapon.setText("");
                    }
                    //Set selected index of current weapon to i
                    Game.setWeaponSelectedIndex(finalI);
                }
            });
        }
    //endregion
    }//close for generateWeapons()

    //region Method to Generate Weapon statistics
    public void generateWeaponStats(Weapon weapon){
        //Set text for indicators: Attack Mod, Weight
        textWeaponIndicatorList.getFirst().setText(String.valueOf(weapon.getAttackMod()));
        textWeaponIndicatorList.get(1).setText(String.valueOf(weapon.getWeight()));
        //Set description for a weapon
        textWeaponDes.setText(String.valueOf(weapon.getDescription()));
        //set weapon's image
        imgWeapon.setIcon(weapon.getWeaponImg());
    }
    //endregion

    //--------------------------------------CREATE FINAL CHOICES OF USER------------------------------------------------
    //region Method to create User's Final Selection
    public void createFinalCharacter() {
        //Get the selected character and weapon from corresponding list with selected index saved in the mainframe Game
        Player selectedPlayer = Game.getPlayerList().get(Game.getCharacterSelectedIndex());
        Weapon selectedWeapon = Game.getWeaponList().get(Game.getWeaponSelectedIndex());

        //Get the name from user input
        String characterName = textCharName.getText();
        selectedPlayer.setName(characterName);//Set the name for selected Player
        selectedPlayer.setWeapon(selectedWeapon);// Set the selected Weapon for selected Player

        //Call method GenerateReport for selected player and save to the variable "summaryCharacter" which declared in mainframe "Game"
        String summaryCharacter = Game.getSummaryCharacter();
        summaryCharacter = selectedPlayer.generateReport();
        Game.setSummaryCharacter(summaryCharacter); //set the text of "summaryCharacter"
    }
//endregion

    //---------------------------------------GETTERS/SETTERS AREA-------------------------------------------------------
    //region GETTERS/SETTERS
    public JButton getBtnReroll() {
        return btnReroll;
    }
    public JButton getBtnStartBattle() {
        return btnStartBattle;
    }
    public ArrayList<JTextField> getTextCharacterIndicatorList() {
        return textCharacterIndicatorList;
    }
    public ArrayList<JTextField> getTextWeaponIndicatorList() {
        return textWeaponIndicatorList;
    }
    public JTextField getTextCharName() {
        return textCharName;
    }
    public ArrayList<JRadioButton> getRdoPlayerList() {
        return rdoPlayerList;
    }
    public JTextArea getTextCharDes() {
        return textCharDes;
    }
    public JLabel getImgCharacter() {
        return imgCharacter;
    }
    public ArrayList<JRadioButton> getRdoWeaponList() {
        return rdoWeaponList;
    }

    public JTextArea getTextWeaponDes() {
        return textWeaponDes;
    }

    public JLabel getImgWeapon() {
        return imgWeapon;
    }

    public ButtonGroup getPlayerRdos() {
        return playerRdos;
    }
    public ButtonGroup getWeaponRdos() {
        return weaponRdos;
    }
    //endregion

}
