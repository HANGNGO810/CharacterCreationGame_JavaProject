/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Classes;

import javax.swing.*;

public class Hammer extends Weapon {
    //region Properties
    private int defensePenalty;
    //endregion
    //region Methods
    // Constructor
    public Hammer(int attackMod, int weight, String description, int defensePenalty) {
        super(attackMod, weight, description);
        this.defensePenalty = defensePenalty;
        super.setWeaponImg(new ImageIcon(this.getClass().getResource("Images//hammer.jpg")));
    }
    //override abstract method
    @Override
    public String getWeaponDetail() {
        return super.toString() + "Defense penalty for Hammer is: " + this.getDefensePenalty() +"\n";
    }
    //endregion
    //region Getters/Setters
    public int getDefensePenalty() {
        return defensePenalty;
    }
    public void setDefensePenalty(int defensePenalty) {
        this.defensePenalty = defensePenalty;
    }
    //endregion
}
