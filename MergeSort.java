public class MergeSort {
    int[] merged = new int[0];

    public MergeSort(int[] myArray) {
        mergeSort(myArray, 0, myArray.length - 1);
    }

    private void mergeSort(int[] arr, int start, int end) {
        int mid = (end - start) / 2;
        if (mid > 1) {
            // First half
            int[] firstHalf = new int[mid];
            for(int i = start; i < mid; i++) {
                firstHalf[i] = arr[i];
            }
            mergeSort(firstHalf, 0, mid);

            // Second half
            int[] secondHalf = new int[end - mid];
            for(int i = mid + 1; i < end; i++) {
                secondHalf[i] = arr[i];
            }
            mergeSort(secondHalf, 0, mid);
            //mergeSort(arr, (mid + 1), arr.length - 1);
        } else {
            merge(arr);
        }
    }

    private void merge(int[] arr) {
        int[] temp = new int[merged.length];
        if (merged.length > 0) {
            // Copy contents of merged array
            for (int i = 0; i < merged.length; i++) {
                temp[i] = merged[i];
            }

            // Create new merged array
            merged = new int[merged.length + arr.length];
        } else {
            merged = new int[merged.length + arr.length];
        }

        int x = 0; // Counter for temp
        int y = 0; // Counter for arr
        for (int j = 0; j < merged.length; j++) {
            if (temp.length < 1) {
                merged[j] = arr[y];
                y++;
            } else if (temp[x] >= arr[y]) {
                merged[j] = arr[y];
                y++;
            } else {
                merged[j] = temp[x];
                x++;
            }
        }
    }

    public String ToString() {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i < merged.length; i++) {
            output.append(merged[i]);
            if (i < merged.length) {
                output.append(", ");
            }
        }
        output.append("]");
        return output.toString();
    }
}
