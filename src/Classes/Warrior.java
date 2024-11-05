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
import java.util.Objects;

public class Warrior extends Player {
    //region Properties
    private int strength;
    //endregion
    //region Methods
    //Constructor
    public Warrior(String name, String type, int defense, int hitPoints, int agility, int baseAttack, int strength, String description) {
        super(name, type, defense, hitPoints, agility, baseAttack, description);
        this.strength = strength;
        super.setImage(new ImageIcon(this.getClass().getResource("Images//Warrior.png")));
    }
    @Override
    public String generateReport() {
        return super.generateReport()+"\n" +"Strength index of this " + this.getType() +" is: "+  this.getStrength() +"\n";
    }
    //endregion
    //region Getter/setter
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    //endregion
}
