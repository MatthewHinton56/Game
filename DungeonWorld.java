/**
 * @(#)DungeonWorld.java
 *
 *
 * @author 
 * @version 1.00 2016/5/12
 */
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.gui.WorldFrame;
import info.gridworld.grid.Location;
public class DungeonWorld extends ActorWorld{
private  Actor[][] floor;	
private Inventory i;
private PlayerGroup p;
private int x,y,floorLevel;
private DungeonGrid g;
private Combat c;
public GameMaster gm;
private static final String type = "Dungeon";
private static final Location[] doorLoc = new Location[]{new Location(3,6),new Location(9,6),new Location(15,6),
		new Location(3,12),new Location(9,12),new Location(15,12),
		new Location(6,3),new Location(6,9),new Location(6,15),
		new Location(12,3),new Location(12,9),new Location(12,15)};
private static final Location[] EXITLOC = new Location[]{
		new Location(0,9),
		new Location(0,15),
		new Location(9,18),
		new Location(18,9),
		new Location(18,15)};
private static final int[][] startLoc = new int[][]{
	{1,1},
	{7,1},
	{13,1},
	{1,7},
	{7,7},
	{13,7},
	{1,13},
	{7,13},
	{13,13}};
    public DungeonWorld(int floorLevel,PlayerGroup p,Inventory i0,GameMaster gm) {
    	this.floorLevel=floorLevel;
    	this.p=p;
    	this.i=i0;
    	c=null;
    	this.gm=gm;
    	if(floorLevel%10==9)
    	{
    		//setMessage("Floor: "+floorLevel);
    		floor = new Actor[7][11];
    		for(int i = 0;i<11;i++){floor[0][i]=new Wall(i,0);floor[6][i]=new Wall(i,6);}
    		for(int q = 0;q<7;q++){floor[q][0]=new Wall(0,q);floor[q][10]=new Wall(10,q);}
    		floor[3][10]= new Exit();
    		floor[1][2] = new Wall(2,1);floor[1][4] = new Wall(4,1);floor[1][3] = new Inn();
    		floor[1][6] = new Wall(2,1);floor[1][8] = new Wall(4,1);floor[1][7] = new Shop();
    		floor[3][2]= new Character();
    		setFocus(2,3);
    		x=2;y=3;
    		System.setProperty("info.gridworld.gui.selection", "hide"); // doesn’t show cell selection
    		System.setProperty("info.gridworld.gui.tooltips", "hide"); // doesn’t show tooltips
    		//System.setProperty("info.gridworld.gui.frametitle", "Dungeon"); // set your own title
        	show();
    	}
    	else
    	{
    	floor = new Actor[19][19];
		for(int i = 0;i<19;i+=6)for(int q =0;q<19;q++){floor[i][q]=new Wall(q,i);floor[q][i]=new Wall(i,q);}
		for(Location l:doorLoc)floor[l.getRow()][l.getCol()]=null;
		floor[9][3]= new Character();
		Location loc = EXITLOC[((int)(Math.random()*5))];
		floor[loc.getRow()][loc.getCol()]=new Exit();
		setUpRooms();
		setFocus(3,9);	
			x=3;y=9;
    	System.setProperty("info.gridworld.gui.selection", "hide"); // doesn’t show cell selection
		System.setProperty("info.gridworld.gui.tooltips", "hide"); // doesn’t show tooltips
		//System.setProperty("info.gridworld.gui.frametitle", "Dungeon"); // set your own title
		setMessage("Floor: "+floorLevel);
    	show();
    	}
    	show();
    }
    public DungeonWorld(int floorLevel,PlayerGroup p,Inventory i0,Actor[][] floor,int x,int y,GameMaster gm) {
    	this.floorLevel=floorLevel;
    	this.p=p;
    	this.i=i0;
    	c=null;
    	this.gm=gm;
    	this.floor=floor;
    	this.x=x;this.y=y;
    	floor[y][x]=new Character();
    	removeExtra();
		setUpRooms();
		setFocus(x,y);	
    	System.setProperty("info.gridworld.gui.selection", "hide"); // doesn’t show cell selection
		System.setProperty("info.gridworld.gui.tooltips", "hide"); // doesn’t show tooltips
		//System.setProperty("info.gridworld.gui.frametitle", "Dungeon"); // set your own title
		setMessage("Floor: "+floorLevel);
    	show();
    }
    public void reset(int level)
    {
    	this.floorLevel=level;
    	floor = new Actor[19][19];
    	for(int i = 0;i<19;i+=6)for(int q =0;q<19;q++){floor[i][q]=new Wall(q,i);floor[q][i]=new Wall(i,q);}
		for(Location l:doorLoc)floor[l.getRow()][l.getCol()]=null;
		floor[9][3]= new Character();
		Location loc = EXITLOC[((int)(Math.random()*5))];
		floor[loc.getRow()][loc.getCol()]=new Exit();
		setUpRooms();
		setFocus(3,9);	
			x=3;y=9;
			show();
    }
    public void setFocus(int x,int y)
    {
    	int x1 = x-3;
    	int x2 = x+3;
    	if(x1<0){x2-=x1;x1=0;}
    	if(x2>18){x1-=(x2-=18);x2=18;}
    	int y1 = y-3;
    	int y2 = y+3;
    	if(y1<0){y2-=y1;y1=0;}
    	if(y2>18){y1-=(y2-=18);y2=18;}
    	if(floor.length==7 && y2>=floor.length-1){y1-=(y2-=6);y2=6;}
    	//System.out.println (""+y1+y2+x1+x2);
    	g = new DungeonGrid(floor,x1,x2,y1,y2);
    	this.setGrid(g);
    	show();
    	
    }
    public void move(int x,int y)
    {
    	int x1 = x-3;
    	int x2 = x+3;
    	if(x1<0){x2-=x1;x1=0;}
    	if(x2>18){x1-=(x2-=18);x2=18;}
    	if(floor[0].length==11&& x2>floor[0].length-1){x1-=(x2-=10);x2=10;}
    	int y1 = y-3;
    	int y2 = y+3;
    	if(y1<0){y2-=y1;y1=0;}
    	if(y2>18){y1-=(y2-=18);y2=18;}
    	if(floor.length==7 && y2>=floor.length-1){y1-=(y2-=6);y2=6;}
    	g.move(floor, x1, x2, y1, y2);
    }
    private void removeExtra()
    {
    	for(int i = 0;i<19;i++)
    		for(int q = 0;q<19;q++)
    			if(floor[i][q] instanceof Character && (i!=y||q!=x))floor[i][q]=null;
    }
     public boolean keyPressed(String description, Location loc)
    {if(c== null || c.over==true){
        if(description.equals("RIGHT")||description.equals("D")){
        	if(floor[y][x+1] instanceof EnemySpawn)
        	{
        		EnemyGroup eG = ((EnemySpawn)floor[y][x+1]).getEnemy();
        		frame.setVisible(false);
        		floor[y][x+1]=new Character();
        		floor[y][x]=null;
        		setFocus(x+1,y);
        		x++;
        		floor[y][x]=null;
        		Combat c = new Combat(eG,p,i,this);
        		frame.dispose();
        		frame.setEnabled(false);
        		
        		
        	}
        	else if(floor[y][x+1] instanceof Exit)
            {System.out.print("Exit move");
            	gm.setLevel(gm.getLevel()+1);
            	//this.setGrid(null);
            	//reset(gm.getLevel());
            	new DungeonWorld(gm.getLevel(),p,i,gm);
            	frame.dispose();
            }
        	else if(floor[y][x+1] instanceof Shop) new ShopGui(floorLevel,i);
        	else if(floor[y][x+1] instanceof Inn) new InnGui(floorLevel,i,p);
        	else if(!(floor[y][x+1] instanceof Wall)){floor[y][x]=null;x++;floor[y][x]=new Character();move(x,y);return true;}
        	}
        if(description.equals("LEFT")||description.equals("A")){
        	if(floor[y][x-1] instanceof EnemySpawn)
        	{
        		EnemyGroup eG = ((EnemySpawn)floor[y][x-1]).getEnemy();
        		frame.setVisible(false);
        		floor[y][x-1]=new Character();
        		floor[y][x]=null;
        		setFocus(x-1,y);
        		x--;
        		Combat c = new Combat(eG,p,i,this);
        		frame.dispose();
        		frame.setEnabled(false);
        		
        		
        	}
        	else if(floor[y][x-1] instanceof Exit)
            {System.out.print("Exit move");
            	gm.setLevel(gm.getLevel()+1);
            	//this.setGrid(null);
            	//reset(gm.getLevel());
            	new DungeonWorld(gm.getLevel(),p,i,gm);
            	frame.dispose();
            }
        	else if(floor[y][x-1] instanceof Shop) new ShopGui(floorLevel,i);
        	else if(floor[y][x-1] instanceof Inn) new InnGui(floorLevel,i,p);
        	else if(!(floor[y][x-1] instanceof Wall)){floor[y][x]=null;x--;floor[y][x]=new Character();move(x,y);return true;}
        	}
        if(description.equals("DOWN")||description.equals("S")){
        	if(floor[y+1][x] instanceof EnemySpawn)
        	{
        		EnemyGroup eG = ((EnemySpawn)floor[y+1][x]).getEnemy();
        		frame.setVisible(false);
        		floor[y+1][x]=new Character();
        		floor[y][x]=null;
        		setFocus(x,y+1);
        		y++;
        		Combat c = new Combat(eG,p,i,this);
        		frame.dispose();
        		frame.setEnabled(false);
        	}
        	else	if(floor[y+1][x] instanceof Exit)
            {System.out.print("Exit move");
            	gm.setLevel(gm.getLevel()+1);
            	//this.setGrid(null);
            	//reset(gm.getLevel());
            	new DungeonWorld(gm.getLevel(),p,i,gm);
            	frame.dispose();
            }
        	else if(floor[y+1][x] instanceof Shop) new ShopGui(floorLevel,i);
        	else if(floor[y+1][x] instanceof Inn) new InnGui(floorLevel,i,p);
        	else if(!(floor[y+1][x] instanceof Wall)){floor[y][x]=null;y++;floor[y][x]=new Character();move(x,y);return true;}}
        
        if(description.equals("UP")||description.equals("W")){
        	if(floor[y-1][x] instanceof EnemySpawn)
        	{
        		EnemyGroup eG = ((EnemySpawn)floor[y-1][x]).getEnemy();
        		frame.setVisible(false);
        		floor[y-1][x]=new Character();
        		floor[y][x]=null;
        		setFocus(x,y-1);
        		y--;
        		Combat c = new Combat(eG,p,i,this);
        		frame.dispose();
        		frame.setEnabled(false);
        	}
        	else if(floor[y-1][x] instanceof Exit)
            {
        		System.out.print("Exit move");
            	gm.setLevel(gm.getLevel()+1);
            	//this.setGrid(null);
            	//reset(gm.getLevel());
            	new DungeonWorld(gm.getLevel(),p,i,gm);
            	frame.dispose();
            }
        	else if(floor[y-1][x] instanceof Shop) new ShopGui(floorLevel,i);
        	else if(floor[y-1][x] instanceof Inn) new InnGui(floorLevel,i,p);
        	else if(!(floor[y-1][x] instanceof Wall)){floor[y][x]=null;y--;floor[y][x]=new Character();move(x,y);return true;}
        	}
        //if(description.equals("T")){move(3,9);return true;}
    }
        return false;
    }
     private static final int ROOMSIZE = 5;
     public void setUpRooms()
     {
    	 for(int[] i: startLoc)
    	 {
    		 if(i[0]!= 7 || i[1]!=1)
    		 {
    		 for(int x = 0;x<2;x++)
    		 {
    			 int xD = ((int)(Math.random()*5))+i[1];
    			 int yD = ((int)(Math.random()*5))+i[0];
    			 if(floor[yD][xD]==null)
    			 { 
    				 floor[yD][xD]= new EnemySpawn(floorLevel);
    			 }
    			}
    		 }
    		 }
    	 }
     
public Actor[][] getConfig()
{
	return floor;
}
public void makeMenu()
{
	new Menu(p,i);
}
public String getType(){return type;}
public int getX(){return x;}public int getY(){return y;}public int getLevel(){return floorLevel;}
}
    
