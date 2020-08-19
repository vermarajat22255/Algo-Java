
public class Leet43_WaterTrapping {
    public int trap(int[] height) {
        int sum = 0, temp = 0;
        int left = 0;
        for (int i = 1; i < height.length; i++) {

            if (height[left] > height[i]) {
                temp += (height[left] - height[i]);
            } else {
                left = i;
                sum += temp;
                temp = 0;
            }
        }
        int right = height.length - 1;
        temp = 0;
        for (int i = right - 1; i >= left; i--) {

            if (height[right] >= height[i]) {
                temp += (height[right] - height[i]);
            } else {
                right = i;
                sum += temp;
                temp = 0;
            }
        }
        return sum;
    }
}