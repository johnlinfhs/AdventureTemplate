
public abstract class Entity {
	protected Location loc;
	protected Room currentRoom;
	
	public Entity(Room r) {
		this (r, r.getRandomEmptyLocation());
	}
	public Entity(Room r, Location loc) {
		this.currentRoom = r;
		this.loc = loc;
		r.put(loc, this);
	}
	void setRoom(Room r){
		this.currentRoom = r;
	}
	Room getRoom(){
		return currentRoom;
	}
	void setLocation(Location l){
		Entity objectValue = null;
		if (this.loc == null)  {
			this.loc = l;
			objectValue = currentRoom.get(loc.row, loc.col);
		}
		if( this.loc != null){
			objectValue = currentRoom.get(loc.row, loc.col);
			currentRoom.put(l.row,l.col, null);
		}
		this.loc = new Location (l.row, l.col);
		currentRoom.put(loc.row, loc.col, objectValue);
	}
	Location getLocation(){
		return loc;
	}
	public abstract String getDisplayString();
}
