/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Classes;

import javax.swing.*;

public class Dagger extends Weapon {
    //region Properties
    private int agilityBonus;
    //endregion
    //region Methods
    //Constructor
    public Dagger(int attackMod, int weight, String description, int agilityBonus) {
        super(attackMod, weight, description);
        this.agilityBonus = agilityBonus;
        super.setWeaponImg(new ImageIcon(this.getClass().getResource("Images//dagger.jpg")));
    }
    //override abstract method
    @Override
    public String getWeaponDetail() {
        return super.toString() + "Agility's Bonus for Dagger is: " +this.getAgilityBonus() +"\n";
    }
    //endregion
    //region Getters/setters
    public int getAgilityBonus() {
        return agilityBonus;
    }
    public void setAgilityBonus(int agilityBonus) {
        this.agilityBonus = agilityBonus;
    }
    //endregion

}
