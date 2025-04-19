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
            else return new Location(col + 1, row);
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
         while (location.getRow() < grid.length - 1 || location.getCol() < grid.length - 1) {
                 sum += grid[location.getRow()][location.getCol()];
                 location = getNextLoc(location.getRow(), location.getCol());
             }
         return sum;
     }

     //main method for testing
     public static void main(String[] args) {
         new GridPath();
     }
     public GridPath() {
         grid = new int[][]{{12, 11, 7, 10, 18}, {3, 21, 8, 17, 22}, {4, 2, 9, 20, 30}, {13, 14, 15, 19, 25}, {5, 16, 0, 1, 6}};
         System.out.println(getNextLoc(0, 0));
         System.out.println(getNextLoc(1, 3));
         System.out.println(getNextLoc(2, 4));
         System.out.println(getNextLoc(4, 3));
         grid = new int[][]{{12, 11, 7, 8}, {30, 3, 2, 33}, {40, 22, 9, 18}, {25, 15, 4, 6}, {5, 43, 0, 1}};
         System.out.println(sumPath(1, 1));
     }
}
