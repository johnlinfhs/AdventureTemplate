
public abstract class Enemy extends Animate {

	public Enemy(Room r) {
		super(r);
	}
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
    public abstract String getDisplayString() ;
}
