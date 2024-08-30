public class Main {

    public static void main(String[] args) {

        // declare variables
        int n, startRow, startCol, endRow, endCol, bishopRow, bishopCol;

        // Test case 1
        n = 5;
        startRow = 0;
        startCol = 0;
        endRow = 4;
        endCol = 3;
        bishopRow = 3;
        bishopCol = 0;
        KnightPath knightPath1 = new KnightPath(n, startRow, startCol, endRow, endCol, bishopRow, bishopCol);
        int knightPath1Result = knightPath1.findPath();
        
        assert knightPath1Result == -1;
        System.out.println(knightPath1Result);

        // Test case 2
        n = 8;
        startRow = 4;
        startCol = 2;
        endRow = 2;
        endCol = 6;
        bishopRow = 2;
        bishopCol = 3;
        KnightPath knightPath2 = new KnightPath(n, startRow, startCol, endRow, endCol, bishopRow, bishopCol);
        int knightPath2Result = knightPath2.findPath();

        assert knightPath2Result == 4;
        System.out.println(knightPath2Result);

        // Test case 3
        n = 5;
        startRow = 2;
        startCol = 2;
        endRow = 4;
        endCol = 4;
        bishopRow = 1;
        bishopCol = 4;
        KnightPath knightPath3 = new KnightPath(n, startRow, startCol, endRow, endCol, bishopRow, bishopCol);
        int knightPath3Result = knightPath3.findPath();

        assert knightPath3Result == 4;
        System.out.println(knightPath3Result);
    }
}
