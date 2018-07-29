/**
 * Created by hanque on 2018/7/29.
 */

public class FloydInGraph {

    private static int INF = -1;

    public static int findEnd(int i, int[][] matrix) {
        int max = 0;
        int end = 0;
        for (int j = 0; j < matrix.length; j++) {
            if(max < matrix[i][j]){
                max = matrix[i][j];
                end = j;
            }
        }
        return end;
    }

    public static int[][] floyd(int[][] matrix) {
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    //matrix[i][j]可能不可达，但matrix[i][k]和matrix[k][j]必须可达
                    //i,j,k两两不相等，避免成环
                    if (i != j && j!=k && i!=k
                            && matrix[i][k] != INF
                            && matrix[k][j] != INF
                            && matrix[i][j] < matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        //初始化邻接矩阵和起点
        int begin = 0;
        int[][] matrix = {
                {0, 10, 20, 50, INF},
                {INF, 0, INF, INF, 20},
                {INF, INF, 0, INF, 30},
                {INF, INF, INF, 0, 10},
                {INF, INF, INF, INF, 0},
        };

        //floyd算法更新距离矩阵
        matrix = FloydInGraph.floyd(matrix);
        //i点开始的最长路径即为距离矩阵第i列除去matrix[i][i]的最大值
        int end = FloydInGraph.findEnd(begin, matrix);
        int distance = matrix[begin][end];
        System.out.println("start at "+ begin + " ,end at " + end + ",the longest path is:" + distance);
    }

}
