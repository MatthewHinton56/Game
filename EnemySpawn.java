
import info.gridworld.actor.*;
public class EnemySpawn extends Actor{
private EnemyGroup e;
	public EnemySpawn(int floor) {
		/*switch(floor)
		{
		case 1:
		break;
		}*/
		e = (EnemyGroup)StandardEnemies.goblins2.clone();
	}
	public EnemyGroup getEnemy()
	{
		return e;
	}
}
