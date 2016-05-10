package info.game;

public class Helmet extends Armor{
	public static final String type = "Helmet";
    public Helmet(int HP, int defense,int price, String name) {
    	super(HP,defense,price,name,type);

    }
}
