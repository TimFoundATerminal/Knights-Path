import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class KnightPath {
    int n;
    int startRow;
    int startCol;
    int endRow;
    int endCol;
    int bishopRow;
    int bishopCol;
    Queue<int[]> queue = new LinkedList<>();
    HashSet<int[]> visited = new HashSet<>();
    int[][] moves = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, 1}};
    
    public KnightPath(int n, int startRow, int startCol, int endRow, int endCol, int bishopRow, int bishopCol) {
        this.n = n;
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
        this.bishopRow = bishopRow;
        this.bishopCol = bishopCol;
    }

    public int findPath() {
        return moves();
    }

    private boolean isValidPosition(int n, int row, int col, int isBishopAlive, int bishopRow, int bishopCol) {
        // check if the position is within the bounds of the board
        boolean inBounds = (row >= 0 && row < n && col >= 0 && col < n);
        if (!inBounds) { return false; }

        // if the bishop is not alive then no need to check for any other conditions
        if (isBishopAlive == 0) { return true; }

        // check if the position is not the bishop position and return true if it is
        if (isBishopPosition(row, col)) { return true; }

        // check if the position is not threatened by the bishop
        boolean isThreatened = (Math.abs(row - bishopRow) == Math.abs(col - bishopCol));
        if (isThreatened) {
            return false;
        }
        return true;

    }

    private boolean isEndPosition(int row, int col) {
        return (row == endRow && col == endCol);
    }

    private boolean isBishopPosition(int row, int col) {
        return (row == bishopRow && col == bishopCol);
    }

    private int moves() {

        // add the starting position to the queue
        queue.add(new int[]{startRow, startCol, 0, 1});

        // while the queue is not empty
        while (!queue.isEmpty()) {

            // get the current position
            int[] current = queue.poll();

            // unpack the current position into variables
            int row = current[0];
            int col = current[1];
            int steps = current[2];
            int isBishopAlive = current[3];

            // check if the current position is the end position
            if (isEndPosition(row, col)) {
                return steps;
            }

            // if the bishop is alive, check if the current position is the bishop position
            if (isBishopAlive == 1 && isBishopPosition(row, col)) {
                isBishopAlive = 0;
            }

            // add the current position to the visited set
            visited.add(new int[]{row, col, isBishopAlive});

            // loop through the possible moves using breadth first search
            for (int i = 0; i < 8; i++) {
                    
                // get the new position
                int newRow = row + moves[i][0];
                int newCol = col + moves[i][1];

                // check if the new position has been visited
                if (visited.contains(new int[]{newRow, newCol, isBishopAlive})) {
                    continue;
                }

                // check if the new position is valid
                if (isValidPosition(n, newRow, newCol, isBishopAlive, bishopRow, bishopCol)) {
                    queue.add(new int[]{newRow, newCol, steps + 1, isBishopAlive});
                }
            }

        }

        // if the end position is not reachable return -1
        return -1;
    }
}
