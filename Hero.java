import java.util.ArrayList;

public class Hero implements Units {

private int maxHP, HP, lvl, XP, strength,spirit,intelligence,speed,defense,id,tStrength,tSpeed,tDefense;
public int mana,manafull;
private String name,type;
public ArrayList<String> spellList;
private Chest chest;
private Gloves gloves;
private Pants pants;
private Helmet helmet;
private Weapon weapon;
private boolean defending;
public static final int coefficent = 10;
public Hero(int strength,int spirit,int intelligence,int speed,int defense,String name,String type,int HP,int id,boolean white,boolean black)
{	spellList = new ArrayList<String>();
	this.id=id;
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
	this.intelligence=intelligence;
	this.strength=strength;
	tStrength = strength;
	this.speed=speed;
	tSpeed = speed;
	this.spirit=spirit;
	this.defense=defense+3;
	tDefense= defense;
	this.type=type;
	this.name=name;
	this.mana=mana;
}
public Chest equipChest(Chest c)
{
	Chest temp = null;
	if(chest!=null){maxHP-=chest.getHP();defense-=chest.getDefense();temp=(Chest)chest.clone();}
	chest=c;
	if(chest!=null){maxHP+=chest.getHP();defense+=chest.getDefense();}
	tDefense= defense;
	return temp;		
}
public Pants equipPants(Pants p)
{
	Pants temp = null;
	if(pants!=null){maxHP-=pants.getHP();defense-=pants.getDefense();temp=(Pants)pants.clone();}
	pants = p;
	if(pants!=null){maxHP+=pants.getHP();defense+=pants.getDefense();}
	tDefense= defense;
	return temp;
}
public Gloves equipGloves(Gloves g)
{
	Gloves temp = null;
	if(gloves!=null){maxHP-=gloves.getHP();defense-=gloves.getDefense();temp=(Gloves)gloves.clone();}
	gloves = g;
	if(gloves!=null){maxHP+=gloves.getHP();defense+=gloves.getDefense();}
	tDefense= defense;
	return temp;
}
public Helmet equipHelmet(Helmet h)
{
	Helmet temp = null;
	if(helmet!=null){maxHP-=helmet.getHP();defense-=helmet.getDefense();temp=(Helmet)helmet.clone();}
	helmet = h;
	if(helmet!=null){maxHP+=helmet.getHP();defense+=helmet.getDefense();}
	tDefense= defense;
	return temp;
}
public Weapon equipWeapon(Weapon w)
{
	Weapon temp = null;
	if(weapon!=null)temp=(Weapon)weapon.clone();
	weapon = w;
	return temp;
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
	this.maxHP+=HP;
	this.strength+=strength;
	tStrength+=strength;
	this.spirit+=spirit;
	this.speed+=speed;
	tSpeed+=speed;
	this.intelligence+=intelligence;
	this.defense+=defense;
	tDefense+=defense;
}
public void levelUpCheck()
{
	
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
public void addHealth(int h){HP+=h;if(HP>maxHP)HP=maxHP;}
public void maxHP(){HP=maxHP;}
public int getMaxHP(){return maxHP;}
@Override
public int play(Units u, String s) {
	if(!this.checkDead())
	{
	switch (s){
	case "attack":if(!u.checkDead()) u.takeDamage(this.getDamage()-u.getDefend());
	return this.getDamage()-u.getDefend();
	case "defend": this.setDefense(this.getDefend());
	return 0;
	}
	}
	return 0;
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
public void addDefense(int d){defense+=d;}
public void addStrength(int s){strength+=s;}
public void addSpeed(int s){speed+=s;}
public boolean equals(Object o)
{
	return this.id==((Hero)o).id;
}
public void heroReset()
{
	strength = tStrength;
	defense = tDefense;
	speed = tSpeed;
}
public int id(){return id;}
public String status()
{
	return "Name: "+name+" " + HP+ "/"+maxHP;
}
}

