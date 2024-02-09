import static edu.leetcode.maxeg.utils.Utils.output;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths main = new UniquePaths();
        output(main.uniquePaths(3,7));
        output(main.uniquePaths(3,2));
    }

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m-1][n-1];
    }
}