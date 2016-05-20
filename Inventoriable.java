

public interface Inventoriable {
	String getName();
	int getPrice();
	String getStat();
	String getType();
	String toString();
	Object clone();
	String save();
}
