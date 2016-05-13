
import info.gridworld.actor.*;
public class EnemySpawn extends Actor{
private EnemyGroup e;
	public EnemySpawn(int floor) {
		switch(floor)
		{
		case 1:
		break;
		}
	}
	public EnemyGroup getEnemy()
	{
		return e;
	}
}
