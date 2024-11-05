/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Classes;

import javax.swing.*;

public class Sword extends Weapon {
    //region Properties
    private int strengthBonus;
    //endregion
    //region Methods
    //Constructor
    public Sword(int attackMod, int weight, String description, int strengthBonus) {
        super(attackMod, weight, description);
        this.strengthBonus = strengthBonus;
        super.setWeaponImg(new ImageIcon(this.getClass().getResource("Images//Sword.jpg")));
    }
    //override abstract method
    @Override
    public String getWeaponDetail() {
        return super.toString() + "Strength's Bonus for Sword is: " +this.getStrengthBonus() +"\n";
    }
    //endregion
    //region Getter/Setter
    public int getStrengthBonus() {
        return strengthBonus;
    }
    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }
    //endregion

}
