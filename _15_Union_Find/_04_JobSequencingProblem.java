import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Q) https://www.geeksforgeeks.org/job-sequencing-problem/
 */
public class _04_JobSequencingProblem {

    //Using Union Find
    //Time: O(NlogD) - D= max possible deadline
    //Space: O(D)
    static int[][] bookSlotsUsingUnionFind(List<Job> jobs) {
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

    //O(N^2)
    //Space: O(N)
    static int[][] bookSlotsGreedyApproach(List<_04_JobSequencingProblem.Job> jobs) {
        jobs.sort((job1, job2) -> job2.profit - job1.profit);
        int maxDeadLine = findMaxDeadLine(jobs);
        int[] jobSequence = new int[maxDeadLine + 1];
        int maxProfit = 0;
        for (_04_JobSequencingProblem.Job job : jobs) {
            int deadLine = job.deadline;
            for (int j = deadLine; j >= 1; j--) {
                if (jobSequence[j] == 0) {
                    jobSequence[j] = job.id;
                    maxProfit += job.profit;
                    break;
                }
            }
        }
        return new int[][]{new int[]{maxProfit}, jobSequence};
    }

    //O(NlogN)
    //Space: O(N)
    static int[][] bookSlotsUsingHeap(List<_04_JobSequencingProblem.Job> jobs) {
        int n = jobs.size();
        jobs.sort(Comparator.comparingInt(j -> j.deadline));
        int maxDeadLine = findMaxDeadLine(jobs);
        int[] jobSequence = new int[maxDeadLine + 1];
        int maxProfit = 0;
        PriorityQueue<_04_JobSequencingProblem.Job> maxHeap = new PriorityQueue<>((j1, j2) -> j2.profit - j1.profit);
        int k = maxDeadLine;
        for (int i = n - 1; i >= 0; i--) {
            _04_JobSequencingProblem.Job j = jobs.get(i);
            maxHeap.add(j);
            int slotsAvailable;
            if (i == 0) {
                slotsAvailable = jobs.get(i).deadline;
            } else {
                slotsAvailable = jobs.get(i).deadline - jobs.get(i - 1).deadline;
            }

            if (slotsAvailable > 0 && maxHeap.size() > 0) {
                _04_JobSequencingProblem.Job job = maxHeap.poll();
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
        int[][] ans = bookSlotsUsingUnionFind(jobs);
        System.out.println("Max Profit: " + ans[0][0]);
        System.out.println("Sequence of Jobs: ");
        for (int i : ans[1]) {
            System.out.print(i);
        }
        System.out.println();
    }
}
