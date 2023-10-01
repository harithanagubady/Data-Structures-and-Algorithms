import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HasPairWithSum {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(scn.nextInt());
        }
        int targetSum = scn.nextInt();
        System.out.println(hasPairWithSum(list, targetSum));
    }

    static boolean hasPairWithSum(List<Integer> list1, int target) {

        List<Integer> comp = new ArrayList<Integer>();
        for (int val : list1) {
            if (comp.indexOf(val) >= 0) {
                return true;
            }
            comp.add(target - val);
        }

        return false;
    }

}
