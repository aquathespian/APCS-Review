public class GridPath
{
    public class Location {
        private int theRow;
        private int theCol;

        public Location(int r, int c) {
            theRow = r;
            theCol = c;
        }

        public int getRow() {return theRow;}
        public int getCol() {return theCol;}

        public String toString() {
            return theRow + ", " + theCol;
        }
    }

    /** Initialized in the constructor with distinct values that never change */
    private int[][] grid;

    /**
     * Returns the Location representing a neighbor of the grid element at row and col,
     * as described in part (a)
     * Preconditions: row is a valid row index and col is a valid column index in grid.
     *                row and col do not specify the element in the last row and last column of grid.
     */
    public Location getNextLoc(int row, int col) {
            if (row == grid.length - 1) return new Location(row, col + 1);
            else if (col == grid[0].length - 1) return new Location(row + 1, col);
            else if (grid[row + 1][col] > grid[row][col + 1]) return new Location(row, col + 1);
            else return new Location(row + 1, col);
    }

    /**
     * computes and returns the sum of all values on a path through grid, as described in
     * part (b)
     * Preconditions: row is a valid row index and col is a valid column index in grid.
     *                row and col do not specify the element in the last row and last column of grid.
     */
     public int sumPath(int row, int col)
     {
         Location location = new Location(row, col);
         int sum = 0;
         while (location.getRow() < grid.length - 1 || location.getCol() < grid[0].length - 1) {
                 sum += grid[location.getRow()][location.getCol()];
                 location = getNextLoc(location.getRow(), location.getCol());
                 System.out.println(location);
             }
         return sum + grid[location.getRow()][location.getCol()];
     }

     //main method for testing
     public static void main(String[] args) {
         new GridPath();
     }
     public GridPath() {
         grid = new int[][]{{12, 3, 4, 13, 5}, {11, 21, 2, 14, 16}, {7, 8, 9, 15, 0}, {10, 17, 20, 19, 1}, {18, 22, 30, 25, 6}};
         System.out.println(getNextLoc(0, 0));
         System.out.println(getNextLoc(1, 3));
         System.out.println(getNextLoc(2, 4));
         System.out.println(getNextLoc(4, 3));
         grid = new int[][]{{12, 30, 40, 25, 5}, {11, 3, 22, 15, 43}, {7, 2, 9, 4, 0}, {8, 33, 18, 6, 1}};
         System.out.println();
         System.out.println(sumPath(1, 1));
     }
}
