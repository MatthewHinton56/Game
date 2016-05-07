/**
 * @(#)Chest.java
 *
 *
 * @author 
 * @version 1.00 2016/5/6
 */


public class Chest extends Armor{

private String name;
    public Chest(int HP, int defense, String name) {
    	super(HP,defense);
    	this.name = name;
    }
    public String getName()
    {
    	return name;
    }
    
}