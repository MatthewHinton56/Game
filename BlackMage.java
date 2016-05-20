import java.util.*;

public class BlackMage extends Hero {
	private static final int startStrength = 1;
	private static final int startIntelligence = 4;
	private static final int startSpirit = 1;
	private static final int startSpeed = 2;
	private static final int startDefense = 2;
	private static final int startHealth = 20;
	public static final String type = "Black Mage";
		public BlackMage(String name,int id) {
			super(startStrength, startSpirit, startIntelligence, startSpeed, startDefense, name, type, startHealth,id,false,true);
			spellList.add(Magic.blackMagicSpell[0]);
			this.mana=5;this.manafull=5;
		}
	public void levelUpCheck()
	{
		
		int spirit = 0;
		int strength = 0;
		if(getLvl()%2==0)spirit++;
		else strength++;
		if(getXP()>Math.pow(2,getLvl())*coefficent){super.levelUP(5, strength, spirit, 1, 2,1);
		if(getLvl()%2==1&&getLvl()<=28)spellList.add(Magic.blackMagicSpell[getLvl()/2]);
		this.mana+=(getLvl()*5);this.manafull+=(getLvl()*5);
		}
		//Health,strength,spirit,speed,intelligence,defense
	}
	public BlackMage(int HP,int maxHP,int mana,int manafull,int lvl,int XP,int strength,int spirit,int intelligence,int speed,int defense,Chest c,Gloves g,Pants p,Helmet h,Weapon w,
ArrayList<String> spells,int id,String name)
{
	super(type,HP,maxHP,mana,manafull,lvl,XP,strength,spirit,intelligence,speed,defense,c,g,p,h,w,spells,id,name);
}}
