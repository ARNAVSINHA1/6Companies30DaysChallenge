class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                    grid[i][j] = 3;
                } else if (grid[i][j] == 1)
                    fresh++;
            }
        }
        int count = 0;

        if (fresh == 0)
            return 0;
        if (q.isEmpty())
            return -1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                int row = temp[0];
                int col = temp[1];

                if (row + 1 < m && grid[row + 1][col] == 1) {
                    q.add(new int[] { row + 1, col });
                    grid[row + 1][col] = 3;
                }

                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    q.add(new int[] { row - 1, col });
                    grid[row - 1][col] = 3;
                }

                if (col + 1 < n && grid[row][col + 1] == 1) {
                    q.add(new int[] { row, col + 1 });
                    grid[row][col + 1] = 3;
                }

                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    q.add(new int[] { row, col - 1 });
                    grid[row][col - 1] = 3;
                }

            }
            count++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count - 1;
    }
}
