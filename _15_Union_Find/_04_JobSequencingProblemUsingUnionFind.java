import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Q) https://www.geeksforgeeks.org/job-sequencing-problem/
 */
public class _04_JobSequencingProblemUsingUnionFind {

    static int[][] bookSlots(List<Job> jobs) {
        jobs.sort((job1, job2) -> job2.profit - job1.profit);
        int maxDeadLine = findMaxDeadLine(jobs);
        int[] jobSequence = new int[maxDeadLine + 1];
        int maxProfit = 0;
        _03_UnionByRankAndPathCompression uf = new _03_UnionByRankAndPathCompression(maxDeadLine + 1);
        int k = maxDeadLine;
        for (Job job : jobs) {
            int availableSlot = uf.find(job.deadline);
            if (availableSlot > 0) {
                uf.union(uf.find(availableSlot - 1), availableSlot);
                jobSequence[k--] = job.id;
                maxProfit += job.profit;
            }
        }
        return new int[][]{new int[]{maxProfit}, jobSequence};
    }

    private static int findMaxDeadLine(List<Job> jobs) {
        int max = 0;
        for (Job x : jobs) {
            if (x.deadline > max) {
                max = x.deadline;
            }
        }
        return max;
    }


    static class Job {
        int id;
        int profit;
        int deadline;

        public Job(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 20, 2));
        jobs.add(new Job(2, 15, 2));
        jobs.add(new Job(3, 10, 1));
        jobs.add(new Job(4, 5, 3));
        jobs.add(new Job(5, 1, 3));
        int[][] ans = bookSlots(jobs);
        System.out.println("Max Profit: " + ans[0][0]);
        System.out.println("Sequence of Jobs: ");
        for (int i : ans[1]) {
            System.out.print(i);
        }
        System.out.println();
    }
}
