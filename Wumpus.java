/***
 * An enemy which can occupy a location in a room and is not to be touched.
 * 
 * @author David
 */
public class Wumpus {
    private Room currentRoom;		// room the Wumpus is in
    private int row, col;			// the location of the wumpus in the room
    
    public Wumpus(Room r) {
        currentRoom = r;      
        row = 6;
        col = 8;
        currentRoom.put(row, col, 3);			// THIS IS BAD.  WHY?
    }
    
    // returns true if enemy was able to move in that direction.
    public boolean move(int direction) {
        int newrow = row;
        int newcol = col;
        
        if (direction == Location.NORTH) newrow--;
        if (direction == Location.SOUTH) newrow++;
        if (direction == Location.EAST) newcol++;
        if (direction == Location.WEST) newcol--;
        
        if (currentRoom.isEmpty(newrow, newcol)) {
            currentRoom.put(row, col, 0);
            currentRoom.put(newrow, newcol, 3);
            row = newrow;
            col = newcol;
            return true;
        }
        
        return false;
    }
    
    public void randomMove() {
        // you can fill this one
        return;
    }
}