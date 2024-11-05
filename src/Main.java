import GUI.Game;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
*   Name: Hang Ngo
*   Date: Mar 25, 2024
*   Description: Assignment 4 - RPG Character Creation
*   Reference to Geoff's Shapetastic Program
* */
public class Main {
    public static void main(String[] args) {
        //Credit to : Geoff
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Game mainFrame = new Game();
                    mainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}