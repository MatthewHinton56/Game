/**
 * @(#)Armor.java
 *
 *
 * @author 
 * @version 1.00 2016/5/6
 */


public abstract class Armor {
private int HP, defense;
    public Armor(int hp, int defense) {
    	HP=hp;
    	defense=defense;
    }
	public int getHP() {
		return HP; 
	}

	public int getDefense() {
		return defense; 
	}
    
}