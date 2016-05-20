import java.util.*;


public class Monk extends Hero {
	private static final int startStrength = 3;
	private static final int startIntelligence = 1;
	private static final int startSpirit = 1;
	private static final int startSpeed = 3;
	private static final int startDefense = 2;
	private static final int startHealth = 23;
	public static final String type = "Monk";
		public Monk(String name,int id) {
			super(startStrength, startSpirit, startIntelligence, startSpeed, startDefense, name, type, startHealth,id,false,false);
		}
	public void levelUpCheck()
	{
	
		if(getXP()>Math.pow(2,getLvl())*coefficent)super.levelUP(5, 2, 0, 2, 0,2);
		//Health,strength,spirit,speed,intelligence,defense
	}
	public Monk(int HP,int maxHP,int mana,int manafull,int lvl,int XP,int strength,int spirit,int intelligence,int speed,int defense,Chest c,Gloves g,Pants p,Helmet h,Weapon w,
ArrayList<String> spells,int id,String name)
{
	super(type,HP,maxHP,mana,manafull,lvl,XP,strength,spirit,intelligence,speed,defense,c,g,p,h,w,spells,id,name);
}
}
