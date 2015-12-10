
public class Sarah extends Enemy{

    private final static int MOVELENGTH = 2; //Sarah's can move 2 spaces for every 1 key action
    
    public Sarah(Room r){ 
    	super(r);
    }
    public Sarah(Room r , Location loc){ 
    	super(r);
    }
    
    // returns true if enemy was able to move in that direction.
    public void setIsAlive(boolean a) {
    	isAlive = a;
    }
    public boolean move(int direction) {
    	if(isAlive){
	    	Location moveTo = Location.locationInDirection(loc, direction , MOVELENGTH);
	        if(currentRoom.isInRoom(moveTo)){
		        if (currentRoom.isEmpty(moveTo.row, moveTo.col)) {
		        	currentRoom.moveEntity(loc, moveTo);
		
		            loc = moveTo;   // update own location
		            return true;
		        }
	        }
    	}
        return false;
    }
    public boolean getIsAlive(){
    	return isAlive;
    }
    public boolean randomMove() {
    	int direction = (int)(Math.random() * 4);
    	return move(direction); 
    }

	public String getDisplayString() {
		return "$";
	}	
}

