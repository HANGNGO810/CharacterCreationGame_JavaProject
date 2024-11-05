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
import java.util.ArrayList;

public class BattleSummary extends JPanel {
    //region Properties
    private JLabel textPlayerName; //area to display player name
    private JLabel textMonsterName; // area to display monster name
    private JLabel imgChar;//image of character
    private JLabel imgMonster; //image of monster
    private JTextArea textReport; //area to display final report
    private JButton btnPlayAgain; //Button PlayAgain
   private ArrayList<Monster>monsterList = new ArrayList<>(); //Array list to store Monster objects
    //endregion
    //region Method BattleSummary()
    public BattleSummary() {

        setLayout(null);
        setVisible(true);
        Font fontSmallLabel = Game.getFontSmallLabel();

        //Display label of this frame
        JLabel frameLabel = new JLabel("Battle To The Death!");
        frameLabel.setFont(Game.getFontBigLabel());
        frameLabel.setBounds(200, 10, 450, 40);

        //Player detail
        JLabel playerLabel = new JLabel("Player: ");
        playerLabel.setFont(fontSmallLabel);
        playerLabel.setBounds(100, 70, 100, 50);

        textPlayerName = new JLabel();
        textPlayerName.setBounds(190, 70, 250, 50);
        textPlayerName.setFont(fontSmallLabel);

        //Monster detail
        JLabel monsterLabel = new JLabel("Monster: ");
        monsterLabel.setFont(fontSmallLabel);
        monsterLabel.setBounds(430, 70, 120, 50);

        textMonsterName = new JLabel();
        textMonsterName.setBounds(535, 70, 200, 50);
        textMonsterName.setFont(fontSmallLabel);

        //Character image
        imgChar= new JLabel();
        imgChar.setBounds(65, 120, 220, 150);

        //Monster image
        imgMonster = new JLabel();
        imgMonster.setBounds(410, 120, 220, 150);

        //Report area
        textReport = new JTextArea();
        textReport.setBounds(100, 310, 530, 320);
        textReport.setFont(Game.getFontTextArea());
        textReport.setLineWrap(true);
        textReport.setWrapStyleWord(true);
        textReport.setSelectedTextColor(Color.black);
        textReport.setMargin(new Insets(10, 10, 10, 10));

        //Button Play Again
        btnPlayAgain = new JButton("PLAY AGAIN");
        btnPlayAgain.setFont(fontSmallLabel);
        btnPlayAgain.setBounds(300, 650, 177, 45);

        //Add to the frame
        add(frameLabel);
        add(playerLabel);
        add(textPlayerName);
        add(monsterLabel);
        add(textMonsterName);
        add(imgChar);
        add(imgMonster);
        add(textReport);
        add(btnPlayAgain);

        //Instantiate Monster objects
        Monster gazer = new Monster("Gazer", "Beast", 30, 44,72, 22, 2, "Images//gazer.png");
        Monster almiraj = new Monster("Almiraj", "Beast", 35, 43,7, 2, 5, "Images//almiraj.png");
        Monster ambushDrake = new Monster("Ambush drake", "Dragon", 38, 48,78, 24, 3, "Images//ambushDrake.png");
        Monster daurgothoth = new Monster("Daurgothoth", "Dragon", 37, 43,72, 25, 4, "Images//daurgothoth.jpg");
        //Add objects to arrayList monsterList
        monsterList.add(gazer);
        monsterList.add(almiraj);
        monsterList.add(ambushDrake);
        monsterList.add(daurgothoth);
    }
    //endregion
    //region Method to Display the Final Report
    public void displayFinalReport(){
        //Display type of player
        String playerType = Game.getPlayerList().get(Game.getCharacterSelectedIndex()).getType();
        textPlayerName.setText(playerType);
        //Display image of character
        imgChar.setIcon((Game.getPlayerList().get(Game.getCharacterSelectedIndex()).getImage()));

        //get random monster in the list of monsters
        int randomNum = (int)(Math.random() * 4); //get the random number from 0 to 3
        //Monster randomMonster = Game.getMonsterList().get(randomNum);
        Monster randomMonster = monsterList.get(randomNum);
        //Display name of a random monster
        textMonsterName.setText(randomMonster.getName());
        imgMonster.setIcon(randomMonster.getImage());

        //Get the summary of character and generate report for monster
        String msg = Game.getSummaryCharacter() + randomMonster.generateReport();
        textReport.setText(msg); //set text of display area to variable msg.
    }
    //endregion
    //region Getters/Setters
    public JLabel getChacraterImg() {
        return imgChar;
    }
    public JLabel getMonsterImg() {
        return imgMonster;
    }
    public JButton getBtnPlayAgain() {
        return btnPlayAgain;
    }
    public JTextArea getReportText() {
        return textReport;
    }
    public JLabel getTextPlayerName() {
        return textPlayerName;
    }
    public JLabel getTextMonsterName() {
        return textMonsterName;
    }
    public JLabel getImgChar() {
        return imgChar;
    }
    public JLabel getImgMonster() {
        return imgMonster;
    }
    public JTextArea getTextReport() {
        return textReport;
    }
    public ArrayList<Monster> getMonsterList() {
        return monsterList;
    }
    public void setChacraterImg(JLabel chacraterImg) {
        this.imgChar = chacraterImg;
    }
    public void setMonsterImg(JLabel monsterImg) {
        this.imgMonster = monsterImg;
    }
    public void setReportText(JTextArea reportText) {
        this.textReport = reportText;
    }
    public void setBtnPlayAgain(JButton btnPlayAgain) {
        this.btnPlayAgain = btnPlayAgain;
    }
    //endregion
}//close for JPanel
