
public class Tester {

	public static void main(String[] args) {
		Hero unit1 = new Warrior("Matthew");
		System.out.println(unit1.getName()+" "+unit1.getType());
		Hero unit2 = new Rogue("Matthew");
		System.out.println(unit2.getName()+" "+unit2.getType());
		Hero unit3 = new Monk("Matthew");
		System.out.println(unit3.getName()+" "+unit3.getType());
		Hero unit4 = new WhiteMage("Matthew");
		System.out.println(unit4.getName()+" "+unit4.getType());
		Hero unit5 = new BlackMage("Matthew");
		System.out.println(unit5.getName()+" "+unit5.getType());
		Hero unit6 = new GrayMage("Matthew");
		System.out.println(unit6.getName()+" "+unit6.getType());
	}

}
