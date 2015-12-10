/***
 * A player in the game.
 * 
 * @author David
 */
public class Player extends Animate {
//    private Room currentRoom;				// room player is in
//    private Location loc;					// location of the player in the room
      
    public Player(Room r){ 
    	super(r);
    }
    public Player(Room r , Location loc){ 
    	super(r);
    }
    
    // returns true if enemy was able to move in that direction.
    public boolean move(int direction) {
    	if(isAlive){
	    	Location moveTo = Location.locationInDirection(loc, direction);
	        
	        if (currentRoom.isEmpty(moveTo.row, moveTo.col)) {
	            currentRoom.moveElementAt(loc, direction);
	            loc = moveTo;   // update own location
	            return true;
	        }
    	}
        return false;
    }
    
    public void setIsAlive(boolean a) {
    	isAlive = a;
    }
    public boolean getIsAlive(){
    	return isAlive;
    }
    
    public boolean randomMove() {
    		int direction = (int)(Math.random() * 4);
            return move(direction);         
    }
    public boolean LargeMove (int direction, int move){
    	if(isAlive){
	    	Location moveTo = Location.locationInDirection(loc, direction, move);
	        
	        if (currentRoom.isEmpty(moveTo.row, moveTo.col)) {
	            currentRoom.moveElementAt(loc, direction);
	            loc = moveTo;   // update own location
	            return true;
	        }
    	}
        return false;
    }
    public boolean randomLargeMove(int move){
    	int direction = (int)(Math.random() * 4);
    	return LargeMove(direction, move);    	
    }
    
    public Location getLocation(){
    	return loc;
    }
    public void setLocation(Location newloc){
    	this.loc = newloc;
    }
	public boolean IsNextToWumpus( Player A ,Wumpus B) {
		int rowDiff = A.getLocation().row - B.getLocation().row;
		int colDiff = A.getLocation().col - B.getLocation().col;
		if(Math.sqrt(Math.pow(rowDiff, 2) + Math.pow(colDiff, 2)) <= 1)
			return true;
		else
			return false;
	}

	public void escape(Player p) {
		Location newloc = currentRoom.getRandomEmptyLocation();
		currentRoom.moveEntity(p.getLocation(), newloc);	
		p.setLocation(newloc);
	}
	public String getDisplayString() {
		return "*";
	}
   
}