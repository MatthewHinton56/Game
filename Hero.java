
public class Hero {

private int HP, lvl, XP, strength,spirit,intelligence,speed,defense;
private String name,type;
private Chest chest;
private Gloves gloves;
private Pants pants;
private Helmet helmet;
private Weapon weapon;
public static final int coefficent = 10;
public Hero(int strength,int spirit,int intelligence,int speed,int defense,String name,String type,int HP)
{
	this.name=name;
	this.type=type;
	chest=StandardItems.loinclothC;
	gloves=StandardItems.loinclothG;
	weapon=StandardItems.woodenStick;
	helmet=StandardItems.loinclothH;
	pants=StandardItems.loinclothP;
	this.HP=HP+3;
	this.lvl=1;
	this.XP=0;
	this.strength=strength;
	this.speed=speed;
	this.spirit=spirit;
	this.defense=defense+3;
	this.type=type;
	this.name=name;
}
public void equipArmor(Armor a)
{
	if(a instanceof Chest){HP-=chest.getHP();defense-=chest.getDefense();chest=(Chest)a;HP+=chest.getHP();defense+=chest.getDefense();}
	if(a instanceof Pants){HP-=pants.getHP();defense-=pants.getDefense();pants=(Pants)a;HP+=pants.getHP();defense+=pants.getDefense();}
	if(a instanceof Gloves){HP-=gloves.getHP();defense-=gloves.getDefense();chest=(Chest)a;HP+=gloves.getHP();defense+=gloves.getDefense();}
	if(a instanceof Helmet){HP-=helmet.getHP();defense-=helmet.getDefense();chest=(Chest)a;HP+=helmet.getHP();defense+=helmet.getDefense();}
}
public void equipWeapon(Weapon w)
{
	weapon = w;
}
public int attack()
{
	return weapon.getDamage()*strength;
}
public int defend(){return defense * 2 / 5;}
public void levelUP(int HP,int strength,int spirit,int speed,int intelligence,int defense)
{
	lvl++;
	this.HP+=HP;
	this.strength+=strength;
	this.spirit+=spirit;
	this.speed+=speed;
	this.intelligence+=intelligence;
	this.defense+=defense;
}
public void addXP(int iXP){XP+=iXP;}
public int getHP() {
	return HP;
}
public int getLvl() {
	return lvl;
}
public int getXP() {
	return XP;
}
public int getStrength() {
	return strength;
}
public int getSpirit() {
	return spirit;
}
public int getIntelligence() {
	return intelligence;
}
public int getSpeed() {
	return speed;
}
public int getDefense() {
	return defense;
}
public String getName() {
	return name;
}
public String getType() {
	return type;
}
public Chest getChest() {
	return chest;
}
public Gloves getGloves() {
	return gloves;
}
public Pants getPants() {
	return pants;
}
public Helmet getHelmet() {
	return helmet;
}
public Weapon getWeapon() {
	return weapon;
}
}
