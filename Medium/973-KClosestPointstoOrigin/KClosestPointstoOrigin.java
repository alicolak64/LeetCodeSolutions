import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

    /*

    We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

    (Here, the distance between two points on a plane is the Euclidean distance.)

    You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

    Example 1:

    Input: points = [[1,3],[-2,2]], K = 1
    Output: [[-2,2]]
    Explanation:
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

     */

    // Link : https://leetcode.com/problems/k-closest-points-to-origin/

    public static void main(String[] args) {

        int[][] points = {{1,3},{-2,2}};
        int K = 1;

        int[][] result = new KClosestPointstoOrigin().kClosest(points, K);

        for (int[] point : result)
            System.out.println(point[0] + " " + point[1]);

    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue < int[] > queue = new PriorityQueue <> (
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int[] point: points) {

            queue.add(point);

            if (queue.size() > k)
                queue.poll();

        }

        int[][] result = new int[k][2];

        while (k > 0)
            result[--k] = queue.poll();

        return result;

    }


}
