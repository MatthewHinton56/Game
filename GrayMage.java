

public class GrayMage extends Hero {
	private static final int startStrength = 1;
	private static final int startIntelligence = 3;
	private static final int startSpirit = 3;
	private static final int startSpeed = 2;
	private static final int startDefense = 2;
	private static final int startHealth = 20;
	public static final String type = "Gray Mage";
		public GrayMage(String name,int id) {
			super(startStrength, startSpirit, startIntelligence, startSpeed, startDefense, name, type, startHealth,id,true,true);
			spellList.add(Magic.whiteMagicSpell[0]);
			spellList.add(Magic.blackMagicSpell[0]);
			this.mana=5;this.manafull=5;
		}
	public void levelUpCheck()
	{
		int spirit = 0;
		int intelligence = 0;
		if(getLvl()%2==0)spirit++;
		else intelligence++;
		if(getXP()>Math.pow(2,getLvl())*coefficent){super.levelUP(5, 0, 2, 1, 2,1);
		if(getLvl()%2==1&&getLvl()<=28)spellList.add(Magic.blackMagicSpell[getLvl()/2]);
		if(getLvl()%2==1&&getLvl()<=28)spellList.add(Magic.whiteMagicSpell[getLvl()/2]);
		this.mana+=(getLvl()*5);this.manafull+=(getLvl()*5);}
		//Health,strength,spirit,speed,intelligence,defense
	}
}
