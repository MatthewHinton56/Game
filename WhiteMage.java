

public class WhiteMage extends Hero {
	private static final int startStrength = 1;
	private static final int startIntelligence = 1;
	private static final int startSpirit = 4;
	private static final int startSpeed = 2;
	private static final int startDefense = 2;
	private static final int startHealth = 20;
	public static final String type = "White Mage";
		public WhiteMage(String name,int id) {
			super(startStrength, startSpirit, startIntelligence, startSpeed, startDefense, name, type, startHealth,id,true,false);
			spellList.add(Magic.whiteMagicSpell[0]);
			this.mana=5;this.manafull=5;
		}
	public void levelUpCheck()
	{
		int strength = 0;
		int intelligence = 0;
		if(getLvl()%2==0)strength++;
		else intelligence++;
		if(getXP()>Math.pow(2,getLvl())*coefficent){super.levelUP(5, strength, 2, 1, intelligence,1);
		if(getLvl()%2==1&&getLvl()<=28)spellList.add(Magic.whiteMagicSpell[getLvl()/2]);
		this.mana+=(getLvl()*5);this.manafull+=(getLvl()*5);}
		//Health,strength,spirit,speed,intelligence,defense
	}

}
