package HW_13;

public class HW_13 {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 2, 8, 3};
        showArr(arr1);


    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int indexMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexMin]) {
                    indexMin = j;
                }
                int temp = array[i];
                array[i] = array[indexMin];
                array[indexMin] = temp;
//                count += 1
            }
        }
//        console.log('count : ' + count)
//        return array;
    }

    //    public static void bubbleSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length -1 -i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//    }
//    public static int[] mergeArrays_1(int[] arr1, int[] arr2) {
//        int[] tempArr = new int[arr1.length + arr2.length];
//        for (int i = 0; i < tempArr.length; i++) {
//            tempArr[i] = i < arr1.length ? arr1[i] : arr2[i - arr1.length];
//        }
//        return tempArr;
//    }
//
//    public static int[] mergeArrays_2(int[] arr1, int[] arr2) {
//        int[] tempArr = new int[arr1.length + arr2.length];
//
//        for (int i = 0; i < arr1.length; i++) {
//            tempArr[i] = arr1[i];
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            tempArr[arr1.length + i] = arr2[i];
//        }
//        return tempArr;
//    }
//
    static void showArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

