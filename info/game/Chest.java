package info.game;
/**
 * @(#)Chest.java
 *
 *
 * @author 
 * @version 1.00 2016/5/6
 */


public class Chest extends Armor{

public static final String type = "Chest";
    public Chest(int HP, int defense,int price, String name) {
    	super(HP,defense,price,name,type);

    }
    
}