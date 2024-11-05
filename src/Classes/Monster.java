/*
 *  Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 *  Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 *  Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 *  Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 *  Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Classes;

import javax.swing.*;

public class Monster extends Character {
    //region Properties
    private int level;
    private String imageLink;
    //endregion
    //region Methods
    // Constructor
    public Monster(String name, String type, int defense, int hitPoints, int agility, int baseAttack, int level, String imageLink) {
        super(name, type, defense, hitPoints, agility, baseAttack);
        this.level = level;
        this.imageLink= imageLink;
        //set image
       super.setImage(new ImageIcon(this.getClass().getResource(this.getImageLink())));
    }
    //toString method
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String generateReport() {
       return    '\n' + "Monster: "+ this.getName()+ '\n' +
                 "---------------------------------"+'\n' +
                "HitPoints: " + this.getHitPoints() + '\t' +
                "Defense:" + this.getDefense()+ '\t' +
                "Agility: " + this.getAgility() + '\t' +
                "BaseAttack: " + this.getBaseAttack() + '\n'+
                "This " + this.getType() + " has level " + this.getLevel() + '\n';
    }
    //endregion
    //regionGetters/Setters
    public String getImageLink() {
        return imageLink;
    }
    public int getLevel() {
        return level;
    }
    //endregion
}
