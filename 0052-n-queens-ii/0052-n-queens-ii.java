class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        count = 0;
        backtrack(0, n, 0, 0, 0);
        return count;
    }

    private void backtrack(int row, int n, int cols, int diag1, int diag2) {
        if (row == n) {
            count++;
            return;
        }

        int availablePositions = ((1 << n) - 1) & ~(cols | diag1 | diag2);

        while (availablePositions != 0) {
            int position = availablePositions & -availablePositions;
            availablePositions &= availablePositions - 1;

            backtrack(
                row + 1,
                n,
                cols | position,
                (diag1 | position) << 1,
                (diag2 | position) >> 1
            );
        }
    }
}