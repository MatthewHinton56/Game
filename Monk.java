
public class Monk extends Hero {
	private static final int startStrength = 2;
	private static final int startIntelligence = 1;
	private static final int startSpirit = 1;
	private static final int startSpeed = 2;
	private static final int startDefense = 3;
	private static final int startHealth = 20;
	public static final String type = "Monk";
		public Monk(String name) {
			super(startStrength, startSpirit, startIntelligence, startSpeed, startDefense, name, type, startHealth);
		}
	public void levelUp()
	{
		int spirit = 0;
		int intelligence = 0;
		if(getLvl()%2==0)spirit++;
		else intelligence++;
		if(getXP()>Math.pow(2,getLvl())*coefficent)super.levelUP(5, 2, spirit, 1, intelligence,2);
	}
}
