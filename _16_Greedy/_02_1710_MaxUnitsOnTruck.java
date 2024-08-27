import java.util.Arrays;
import java.util.Comparator;

public class _02_1710_MaxUnitsOnTruck {

    //Fractional Knapsack Method
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //place boxes in such a way that total units have to be maximum

        //sort the boxes based on max no of units
        Arrays.sort (boxTypes, Comparator.comparingInt(a -> a[1]));
        int n = boxTypes.length;
        int res = 0;
         for (int i = n - 1; i >= 0; i--) {
             if (truckSize >= boxTypes[i][0]) {
                 truckSize -= boxTypes[i][0];
                 res += (boxTypes[i][0] * boxTypes[i][1]);
             } else {
                 res += (truckSize * boxTypes[i][1]);
                 truckSize = 0;
                 break;
             }
         }
        return res;
    }
}
