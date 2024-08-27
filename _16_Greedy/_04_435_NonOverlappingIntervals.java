import java.util.Arrays;
import java.util.Comparator;

public class _04_435_NonOverlappingIntervals {

    /*
    https://leetcode.com/problems/non-overlapping-intervals/description/

     */

    public int eraseOverlapIntervals(int[][] intervals) {
        //sort based on finish time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));//[1,2][2,3][1,3][3,4]
        int n = intervals.length;
        int count = 1;
        //if start time of current interval is >= end time of last interval, count it as selected interval
        int last = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= last) {
                count++;
                last = intervals[i][1];
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println(new _04_435_NonOverlappingIntervals().eraseOverlapIntervals(arr));
    }
}
