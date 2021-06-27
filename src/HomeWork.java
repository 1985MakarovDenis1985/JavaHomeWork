public class HomeWork {

    public static void main(String[] args) {
        int[] arr1 = {1, 2,3};
        int[] arr2 = {4, 5, 6};
        int[] arr3 = mergeArrays_1(arr1, arr2);
        int[] arr4 = mergeArrays_2(arr1, arr2);

//        showArr(arr3);
//        showArr(arr4);

    }

    public static int[] mergeArrays_1(int[] arr1, int[] arr2) {
        int[] tempArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = i < arr1.length ? arr1[i] : arr2[i - arr1.length];
        }
        return tempArr;
    }

    public static int[] mergeArrays_2(int[] arr1, int[] arr2) {
        int[] tempArr = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            tempArr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            tempArr[arr1.length + i] = arr2[i];
        }
        return tempArr;
    }

    static void showArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

