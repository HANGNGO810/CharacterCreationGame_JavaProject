/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Classes;

import GUI.Game;

import javax.swing.*;

public class Wizard extends Player{
    //region Properties
    private int intelligence;
    //endregion
    //region Methods
    // Constructor
    public Wizard(String name, String type, int defense, int hitPoints, int agility, int baseAttack, int intelligence, String description) {
        super(name, type, defense, hitPoints, agility, baseAttack, description );
        this.intelligence = intelligence;
        super.setImage(new ImageIcon(this.getClass().getResource("Images//Wizard.jpg")));
    }
    //override abstract method
    @Override
    public String generateReport() {
        return super.generateReport() +"\n" +"Intelligence index of this " + this.getType() +" is: "+   this.getIntelligence() +"\n";
    }
    //endregion
    //region Getters/setters
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    //endregion

}
