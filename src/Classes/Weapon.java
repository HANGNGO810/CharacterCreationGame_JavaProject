/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Classes;

import javax.swing.*;

public abstract class Weapon {
    //region Properties
    private int attackMod;
    private int weight;
    private String description;
    private ImageIcon weaponImg;
    //endregion
    //region Methods
    // Constructor
    public Weapon(int attackMod, int weight, String description) {
        this.attackMod = attackMod;
        this.weight = weight;
        this.description = description;
    }
    //toString method
    @Override
    public String toString() {
        return  '\n' + "Weapon: " +
                this.getClass().getSimpleName()+'\t' +
                "AttackMod: " + attackMod +'\t' +
                "Weight: " + weight +'\n';
    }
    //Abstract method
    public abstract String getWeaponDetail();
    //endregion
    //region Getters/Setters
    //Getters/Setters
    public int getAttackMod() {
        return attackMod;
    }
    public int getWeight() {
        return weight;
    }
    public String getDescription() {
        return description;
    }
    public ImageIcon getWeaponImg() {
        return weaponImg;
    }
    public void setWeaponImg(ImageIcon weaponImg) {
        this.weaponImg = weaponImg;
    }
    //endregion
}


