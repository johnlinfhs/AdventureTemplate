
public abstract class Animate extends Entity{
	protected boolean isAlive = true;
	
	public Animate ( Room r){
		super(r);		
	}
	public Animate ( Room r ,Location loc ){
		super(r , loc);		
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
	 public boolean ChasePlayer( Player p){
	    	if(p.getLocation().row > loc.row) return move(Location.EAST);
	    	if(p.getLocation().col > loc.col) return move(Location.NORTH);
	    	if(p.getLocation().row > loc.row) return move(Location.WEST);
	    	return move(Location.SOUTH);
	    }
	    public boolean RunFromPlayer(Player p){
	    	if(p.getLocation().row > loc.row) return move(Location.WEST);
	    	if(p.getLocation().col > loc.col) return move(Location.SOUTH);
	    	if(p.getLocation().row > loc.row) return move(Location.EAST);
	    	return move(Location.NORTH);
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
