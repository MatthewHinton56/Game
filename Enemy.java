
public class Enemy implements Units{
private int HP,MaxHP,damage,defense,XP,gold,lvl,speed,id;
private boolean defending;
private String name;
	public Enemy(int HP, int damage,int defense, int XP,int gold,int lvl,String name,int speed,int id) {
		this.id=id;
	this.HP=HP;
	MaxHP=HP;
	this.damage=damage;
	this.defense=defense;
	this.XP=XP;
	this.gold=gold;
	this.lvl=lvl;
	this.name=name;
	this.speed=speed;
	this.defending=false;
	}
	
	public boolean checkDead(){return HP<=0;}
	public int getHP() {
		return HP;
	}
	public int getSpeed(){return speed;}
	public int getMaxHP() {
		return MaxHP;
	}
	public int getDamage() {
		return damage;
	}
	public int getXP() {
		return XP;
	}
	public int getGold() {
		return gold;
	}
	public int getLvl() {
		return lvl;
	}
	public String getName() {
		return name;
	}
	public Object clone()
	{
		return new Enemy(HP,damage,defense,XP,gold,lvl,name,speed,id);
	}
	public void takeDamage(int damage)
	{
		if(damage<=0)damage=0;
		HP-=damage;
	}
	public int getDefend() {
		return defense;
	}

	public void setDefense(int defense) {
		defense+=defense;
	}

	public int defend() {
		return defense/2;
	}

	public void play(Units u, String s) {
		if(!this.checkDead())
		{
		switch (s){
		case "attack":if(!u.checkDead()) u.takeDamage(this.getDamage()-u.getDefend());
		case "defend": this.setDefense(this.defend());
		}
		}
	}


	public boolean isDefending() {
		return defending;
	}


	public void reset() {
		if(defending)defense-=defend();
		defending=false;
	}
	public boolean eqauls(Object o)
	{
		return (this.id==((Enemy)o).id);
	}
	public int id(){return id;}
	public String status()
	{
		return "Name: "+name+" " + HP+ "/"+MaxHP;
	}
}
