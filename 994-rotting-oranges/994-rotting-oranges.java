class Solution {
    public class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] grid) {
    if (grid == null || grid.length == 0)
      return 0;
    int rows = grid.length;
    int cols = grid[0].length;
    LinkedList<Pair> queue = new LinkedList<>();
    int fresh = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 2) {
          queue.addLast(new Pair(i, j));
        } else if (grid[i][j] == 1) {
          fresh++;
        }
      }
    }
    if (fresh == 0)
      return 0;

    int count = -1;
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    while (!queue.isEmpty()) {
      ++count;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Pair point = queue.removeFirst();
        for (int dir[] : dirs) {
          int x = point.row + dir[0];
          int y = point.col + dir[1];
          if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
            continue;
          grid[x][y] = 2;
          queue.addLast(new Pair(x, y));
          fresh--;
        }
      }
    }
    return fresh == 0 ? count : -1;
  }
}