
/**
 * @(#)Armor.java
 *
 *
 * @author 
 * @version 1.00 2016/5/6
 */


public class Armor implements Inventoriable {
private int HP, defense,price;
private String name,type;
    public Armor(int hp, int defense,int price,String name,String type) {
    	HP=hp;
    	this.defense=defense;
    	this.price=price;
    	this.name=name;
    	this.type=type;
    }
	public int getHP() {
		return HP; 
	}

	public int getDefense() {
		return defense; 
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	@Override
	public String getStat() {
		// TODO Auto-generated method stub
		return name+" "+" HP: "+HP+" Defense: "+defense;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	public Object clone()
	{
		return new Armor(HP,defense,price,name,type);
	}
	public String toString()
	{
		return "Name:" + name+" Type:"+type+" Price:"+price;
	}
    
}