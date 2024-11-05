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

public class Cleric extends Player {
    //region Properties
    private int wisdom;
    //endregion
    //region Methods
    //Constructor
    public Cleric(String name, String type, int defense, int hitPoints, int agility, int baseAttack,int wisdom,String description) {
        super(name, type, defense, hitPoints, agility, baseAttack, description);
        this.wisdom = wisdom;
        super.setImage(new ImageIcon(this.getClass().getResource("Images//Cleric.jpg")));
    }
    //override abstract method
    @Override
    public String generateReport() {
        return super.generateReport()+"\n" +"Wisdom index of this " + this.getType() +" is: "+  this.getWisdom()  +"\n";
    }
    //endregions
    //region Getters/Setters
    public int getWisdom() {
        return wisdom;
    }
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }
    //endregion

}
