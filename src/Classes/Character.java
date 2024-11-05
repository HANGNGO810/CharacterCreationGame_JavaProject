/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Classes;

import javax.swing.*;

public abstract class Character {
    //region Properties
    private String name;
    private String type;
    private int defense;
    private int hitPoints;
    private int agility;
    private int baseAttack;
    private ImageIcon image;
    //endregion
    //region Methods
    // Constructor
    public Character(String name, String type, int defense, int hitPoints, int agility, int baseAttack) {
        this.name = name;
        this.type = type;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.agility = agility;
        this.baseAttack = baseAttack;
    }
    //toString method
    @Override
    public String toString() {
        return "Player: " +
                   name + '\n' +
                "---------------------------------"+ '\n' +
                "Class: "+ this.getClass().getSimpleName() + '\n' +
                "HitPoints: " + hitPoints + '\t' +
                "Defense:" + defense + '\t' +
                "Agility: " + agility + '\t' +
                "BaseAttack: " + baseAttack + '\t';
    }
    //Abstract method
    public abstract String generateReport();
    //endregion
    //region Getters/Setters
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getDefense() {
        return defense;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public int getAgility() {
        return agility;
    }
    public int getBaseAttack() {
        return baseAttack;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }
    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }
    public ImageIcon getImage() {
        return image;
    }
    public void setImage(ImageIcon image) {
        this.image = image;
    }
    public void setName(String name) {
        this.name = name;
    }
    //endregion
}

