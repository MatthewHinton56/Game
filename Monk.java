

public class Monk extends Hero {
	private static final int startStrength = 3;
	private static final int startIntelligence = 1;
	private static final int startSpirit = 1;
	private static final int startSpeed = 3;
	private static final int startDefense = 2;
	private static final int startHealth = 23;
	public static final String type = "Monk";
		public Monk(String name,int id) {
			super(startStrength, startSpirit, startIntelligence, startSpeed, startDefense, name, type, startHealth,id);
		}
	public void levelUp()
	{
	
		if(getXP()>Math.pow(2,getLvl())*coefficent)super.levelUP(5, 2, 0, 2, 0,2);
		//Health,strength,spirit,speed,intelligence,defense
	}
}
