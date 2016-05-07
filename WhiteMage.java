
public class WhiteMage extends Hero {
	private static final int startStrength = 1;
	private static final int startIntelligence = 1;
	private static final int startSpirit = 3;
	private static final int startSpeed = 2;
	private static final int startDefense = 2;
	private static final int startHealth = 20;
	public static final String type = "White Mage";
		public WhiteMage(String name) {
			super(startStrength, startSpirit, startIntelligence, startSpeed, startDefense, name, type, startHealth);
		}
	public void levelUp()
	{
		int strength = 0;
		int intelligence = 0;
		if(getLvl()%2==0)strength++;
		else intelligence++;
		if(getXP()>Math.pow(2,getLvl())*coefficent)super.levelUP(5, strength, 3, 1, intelligence,1);
	}

}
