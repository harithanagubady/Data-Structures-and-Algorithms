/*
https://leetcode.com/problems/meeting-rooms-ii/description/
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _10_LC253_MeetingRooms2 {
    public static void main(String[] args) {
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms1(intervals1));
        int[][] intervals2 = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms2(intervals2));
    }

    public static int minMeetingRooms1(int[][] intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for (int[] i : intervals) {
            starts.add(i[0]);
            ends.add(i[1]);
        }

        starts.sort(Comparator.comparingInt(a -> a));
        ends.sort(Comparator.comparingInt(a -> a));

        int i = 0, end = 0, rooms = 0, minRooms = 0;
        while (i < starts.size() && end < ends.size()) {
            if (starts.get(i) < ends.get(end)){
                rooms++;
                i++;
            }
            else {
                end++;
                rooms--;
            }
            minRooms = Math.max(rooms, minRooms);
        }
        return minRooms;
    }

    public static int minMeetingRooms2(int[][] intervals) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for (int[] i : intervals) {
            starts.add(i[0]);
            ends.add(i[1]);
        }

        starts.sort((a, b) -> a - b);
        ends.sort((a, b) -> a - b);

        int end = 0, rooms = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts.get(i) < ends.get(end)) rooms++;
            else end++;
        }
        return rooms;
    }
}
