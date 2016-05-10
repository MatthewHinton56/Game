package info.game;

public class StandardEnemies {
	public static final Enemy goblin1 = new Enemy(10, 6, 1, 4, 5, 1, "Goblin 1",1,0);
	public static final Enemy goblin2 = new Enemy(10, 6, 1, 4, 5, 1, "Goblin 2",1,1);
	public static final Enemy goblin3 = new Enemy(10, 6, 1, 4, 5, 1, "Goblin 3",1,2);
	public static final Enemy goblin4 = new Enemy(10, 6, 1, 4, 5, 1, "Goblin 4",1,3);
	public static final EnemyGroup goblins2 = new EnemyGroup(new Enemy[]{goblin1,goblin2});
	public static final EnemyGroup goblins4 = new EnemyGroup(new Enemy[]{goblin1,goblin2,goblin3,goblin4});

}
