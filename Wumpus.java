/***
 * An enemy which can occupy a location in a room and is not to be touched.
 * 
 * @author David
 */
public class Wumpus extends Enemy{
    public Wumpus(Room r){ 
    	super(r);
    }
    public Wumpus(Room r , Location loc){ 
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

	public String getDisplayString() {
		return "w";
	}

    
}