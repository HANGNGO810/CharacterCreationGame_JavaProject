/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Classes;

import javax.swing.*;

public class Player extends Character {
    //region Properties
    private String description;
    private Weapon weapon; // Aggregation Implementation
    //endregion
    //region Methods
    // Constructor
    public Player(String name, String type, int defense, int hitPoints, int agility, int baseAttack, String description) {
        super(name, type, defense, hitPoints, agility, baseAttack);
        this.description = description;
        this.weapon = getWeapon();
    }
    //Override abstract method
    @Override
    public String generateReport() {

        return super.toString() + "\n" + this.getWeapon().getWeaponDetail();
    }
    //endregion
    //region Getters/Setters
    public String getDescription() {
        return description;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    //endregion
}



