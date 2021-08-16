
package memory.service;

public class MemoryService {
    public static int getMaxAvailableMemory() {
        int left = 0;
        int right = Integer.MAX_VALUE;
        int middle = 0;

        while (left <= right) {
            middle = (left + right) / 2;
            boolean lengthOfArr = trueArrLength(middle + 1);

            if (!lengthOfArr && trueArrLength(middle)) {
                return middle;
            } else if (lengthOfArr) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return middle;
    }

    private static boolean trueArrLength(int arrLength) {
        try {
            int[] arr = new int[arrLength];
            return true;
        } catch (Throwable err) {
            return false;
        }
    }
}