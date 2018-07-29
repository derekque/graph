/**
 * Created by hanque on 2018/7/29.
 */

import java.util.ArrayList;
import java.util.List;


public class FloydInGraph {



    public FloydInGraph(int size) {
//        this.path = new int[size][size];
        this.dist = new int[size][size];
        this.size = size;
    }

    private static int size;

    private static int INF = -1;

    //邻接矩阵
    private static int[][] dist;

//    private static int[][] path;

    //最长距离
    private static int distance = 0;

    //结束节点
    private static int end = 0;

    public static void main(String[] args) {
        FloydInGraph graph = new FloydInGraph(5);
        int[][] matrix = {
                {0, 10, 20, 50, INF},
                {INF, 0, INF, INF, 20},
                {INF, INF, 0, INF, 30},
                {INF, INF, INF, 0, 10},
                {INF, INF, INF, INF, 0},
        };
        int begin = 0;
        graph.initial(matrix);
        graph.floyd();
        graph.findPath(begin);
        System.out.println("start at "+ begin + " ,end at " + end + ",the longest path is:" + distance);
    }

    public static void findPath(int i) {
        distance = 0;
        for (int j = 0; j < size; j++) {
            if(distance < dist[i][j]){
                distance = dist[i][j];
                end = j;
            }
        }
    }

    public static void initial(int[][] matrix){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dist[i][j] = matrix[i][j];
            }
        }
    }

    public static void floyd() {
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i != j && j!=k && i!=k
                            && dist[i][k] != INF
                            && dist[k][j] != INF
                            && dist[i][j] < dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

    }
}
