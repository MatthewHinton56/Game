

public class Weapon implements Inventoriable{
private int damage,price;
private String name;
public static final String type = "Weapon";
public Weapon(int damage,String name,int price)
{
	this.damage=damage;
	this.name=name;
	this.price=price;
}
public int getDamage(){return damage;}
public String getName(){return name;}
public int getPrice() {
	return price;
}
public String getStat() {
	return "Type "+type+" Damage: "+damage;
}
public String getType() {
	return type;
}
public Object clone()
{
	return new Weapon(damage,name,price);
}
public String toString()
{
	return "Name:" + name+" Type:"+type+" Price:"+price;
}
}
