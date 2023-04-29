import java.util.Arrays;

// This algorithm uses the last element in the array to quicksort the array
public class quicksort_end_pivot{
    public static void quickSort(int[] array, int left, int right) {
        // Makes sure that there is something to sort. If elements cross, then stop recursion
        if (left >= right){
            return;
        }
        // This chooses pivot to be the last element in the array
        int pivot = array[right];
        //call the partition method to split the array
        int index = partition(array, left, right, pivot);

        // This will recursively apple the quickSort method to the left and right new arrays
        //quicksort method on left until the partition index - 1
        quickSort(array, left, index - 1);
        //quicksort after the partitition until the right index
        quickSort(array, index + 1, right);
    }


    public static int partition(int array[], int left, int right, int pivot) {
        //i is the place before left. increase i so we can switch i and the right later 
        int i = left - 1;

        // Loop through each index in the array from left to right, without doing right because that is the pivot
        for (int index = left; index < right; index++) {
            // If the current element is less than the value of the pivot, then it will run this if loop
            if (array[index] < pivot){
                // This increments the i index
                i++;
                // This will swap the current element with the element at index i
                // this swap makes sure that the lowest element becomes the new pivot
                swap(array, i, index);
            }
        }

        // This will switch the the pivot, which is at positon riight, with the value/element that is the last one to be less than the pivot
        swap(array, i + 1, right);
        // This returns the new index of the pivot
        return i + 1; 
    }
    //swap method that we can call to swap two elements in array
    private static void swap(int[] array, int i, int j){
        //switch the places of i and j
        int temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
    }

    // This is the main method that will test our quickSort algorithm
    public static void main(String[] args) {
        int[] array = {15, 3, 2, 1, 9, 5, 7, 8, 6};

        quickSort(array, 0, array.length - 1);

        System.out.println("This is the final sorted Array: ");
        System.out.println(Arrays.toString(array));
    }
}