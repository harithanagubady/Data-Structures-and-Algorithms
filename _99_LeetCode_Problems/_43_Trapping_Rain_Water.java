public class _43_Trapping_Rain_Water {
    public int approach1(int[] height) {
        int n = height.length;

        if (n <= 2) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            int j = n - i - 1;
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        int totalWater = 0;

        for (int k = 0; k < n; k++) {
            int water = Math.min(leftMax[k], rightMax[k]);
            totalWater += (water - height[k]);
        }
        return totalWater;
    }

    public int approach2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int totalWater = 0;

        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                totalWater += (maxLeft - height[left]);
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                totalWater += (maxRight - height[right]);
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        _43_Trapping_Rain_Water obj = new _43_Trapping_Rain_Water();
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(obj.approach1(arr));
        System.out.println(obj.approach2(arr));
    }
}
