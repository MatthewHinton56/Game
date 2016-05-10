package info.game;

public interface Units {
	int getDamage();
	int getDefend();
	int getSpeed();
	void setDefense(int defense);
	int defend();
	boolean checkDead();
	boolean isDefending();
	int play(Units u, String s);
	void takeDamage(int damage);
	void reset();
	int id();
	int getHP();
	int getMaxHP();
	String status();
}
