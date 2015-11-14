/***
 * A room in the game. A room contains a 2d int array to represent the things in
 * the room. See the Game class for int constants that represent different game
 * things. For example: Game.WUMPUS = 3; These are the values in the room int
 * array.
 * 
 * @author David
 */
public class Room {
	private int[][] room; 					// 2d grid for the room
	private static String[] displaySymbols = { ".", "*", "X", "W" };
	private int width, height;
	private String longDescription;
	private String shortDescription;

	public Room(int w, int h) {
		width = w;
		height = h;
		room = new int[h][w];
		addBorder();
	}

	// Adds a border of wall objects around the edges of the room
	private void addBorder() {
		for (int i = 0; i < room.length; i++) {
			room[i][0] = room[i][room[0].length - 1] = 2;
		}

		for (int j = 0; j < room[0].length; j++) {
			room[0][j] = room[room.length - 1][j] = 2;
		}
	}

	/**
	 * Returns the value of (row, col) in the room.  Possible values include
	 * Game.WUMPUS, Game.WALL, Game.PLAYER, Game.EMPTY, Game.INVALID
	 * 
	 * @param row the row in the room grid
	 * @param col the column in the room grid
	 * @return what is at that location in the room.
	 */
	public int get(int row, int col) {
		if (isInRoom(row, col)) {
			return room[row][col];
		} else {
			return Game.INVALID;
		}
	}

	/**
	 * Put a new value into the room grid at (row, col).  Possible values include
	 * Game.WUMPUS, Game.WALL, Game.PLAYER, Game.EMPTY
	 * 
	 * @param row the row to place the new value 
	 * @param col the column to place the new value
	 * @param value the value to be placed at (row, col)
	 */
	public void put(int row, int col, int value) {
		if (isInRoom(row, col))
			room[row][col] = value;
	}

	/**
	 * Return a string representation for the room.  This is what actually
	 * gets displayed by the GUI class and what the user sees.
	 */
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (int r = 0; r < room.length; r++) {
			for (int c = 0; c < room[0].length; c++) {
				b.append(displaySymbols[room[r][c]]);
			}
			b.append("\n");
		}
		return b.toString();
	}

	int getWidth() {
		return room[0].length;
	}

	int getHeight() {
		return room.length;
	}

	// return true if (newrow, newcol) is Game.EMPTY
	boolean isEmpty(int newrow, int newcol) {
		return get(newrow, newcol) == 0;
	}

	// return true if Location loc is Game.EMPTY
	boolean isEmpty(Location loc) {
		return isEmpty(loc.row, loc.col);
	}

	// Move the element at Location loc in the direction
	// This places the element at the new location and sets
	// the previous location to Game.EMPTY
	void moveElementAt(Location loc, int direction) {
		if (!isInRoom(loc))
			return;

		Location moveTo = Location.locationInDirection(loc, direction);

		if (!isInRoom(moveTo))
			return;

		room[moveTo.row][moveTo.col] = room[loc.row][loc.col]; // move thing
		room[loc.row][loc.col] = Game.EMPTY; // old square empty
	}

	// return true if (row, col) is a valid location in the room
	public boolean isInRoom(int row, int col) {
		if (row < 0 || col < 0) {
			return false;
		}
		if (row >= room.length) {
			return false;
		}
		if (col >= room[0].length) {
			return false;
		}
		return true;
	}

	public boolean isInRoom(Location loc) {
		return isInRoom(loc.row, loc.col);
	}

	// return a random location in the room
	public Location getRandomLocation() {
		return new Location((int) (Math.random() * height),
				(int) (Math.random() * width));
	}
}