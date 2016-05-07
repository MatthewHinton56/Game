
public class Hero implements Units {

private int maxHP, HP, lvl, XP, strength,spirit,intelligence,speed,defense,id;
private String name,type;
private Chest chest;
private Gloves gloves;
private Pants pants;
private Helmet helmet;
private Weapon weapon;
private boolean defending;
public static final int coefficent = 10;
public Hero(int strength,int spirit,int intelligence,int speed,int defense,String name,String type,int HP,int id)
{	this.id=id;
	defending = true;
	this.name=name;
	this.type=type;
	chest=StandardItems.loinclothC;
	gloves=StandardItems.loinclothG;
	weapon=StandardItems.woodenStick;
	helmet=StandardItems.loinclothH;
	pants=StandardItems.loinclothP;
	this.HP=HP+3;
	this.maxHP=HP+3;
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
public void setDefending(boolean d){defending = d;}
public boolean getDefending(){return defending;}
public int attack()
{
	return weapon.getDamage()*strength;
}
public int defend(){return defense * 2 / 5;}
public void levelUP(int HP,int strength,int spirit,int speed,int intelligence,int defense)
{
	lvl++;
	this.HP+=HP;
	this.maxHP=HP;
	this.strength+=strength;
	this.spirit+=spirit;
	this.speed+=speed;
	this.intelligence+=intelligence;
	this.defense+=defense;
}
public void takeDamage(int damage){if(damage<=0)damage=0;HP-=damage;}
public boolean checkDead(){return HP<=0;}
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
@Override
public int getDamage() {
	return attack();
}
public int getDefend()
{
	return defend();
}
public int getMaxHP(){return maxHP;}
@Override
public void play(Units u, String s) {
	System.out.println("test");
	if(!this.checkDead())
	{
	System.out.print("Test");
	switch (s){
	case "attack":if(!u.checkDead()) u.takeDamage(this.getDamage()-u.getDefend());
	break;
	case "defend": this.setDefense(this.getDefend());
	break;
	}
	}
}
@Override
public void setDefense(int defense) {
	this.defense+=defense;
	defending = true;
	
}
@Override
public boolean isDefending() {
	return defending;
}
@Override
public void reset() {
	if(defending)defense-=defend();
	defending = false;
	
}
public boolean equals(Object o)
{
	return this.id==((Hero)o).id;
}
public int id(){return id;}
public String status()
{
	return "Name: "+name+" " + HP+ "/"+maxHP;
}
}

