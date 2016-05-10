package info.game;
/**
 * @(#)Gloves.java
 *
 *
 * @author 
 * @version 1.00 2016/5/6
 */


public class Gloves extends Armor {
	public static final String type = "Gloves";
    public Gloves(int HP, int defense,int price, String name) {
    	super(HP,defense,price,name,type);

    }
}