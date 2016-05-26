/**
 * @(#)Stat.java
 *
 *
 * @author 
 * @version 1.00 2016/5/12
 */
import info.gridworld.actor.Actor;
import java.awt.Color;
public class Stat extends Actor {
private Units unit;
private String stat;
    public Stat(Units unit) {
    	this.unit = unit;
    	stat = unit.getHP()+"/"+unit.getMaxHP();
    	setColor(Color.white);
    }
    public String getText()
    {stat = unit.getHP()+"/"+unit.getMaxHP();
    	return stat;
    } 
    public void reset()
    {stat =unit.getHP()+"/"+unit.getMaxHP();
    }
}