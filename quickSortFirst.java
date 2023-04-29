public class quickSortFirst {
    // This will quickly sort the algorithm with first element as pivot
    public static void quickSortFirst(int[] arr, int left, int right) {
      if (left >= right) {
        return;
      }
        // this is partition(separate) the array
        int pivotIndex = partition(arr, left, right);
        // this will recursively apply the quick sort method to the left and to the right sub-arrays
        quickSortFirst(arr, left, pivotIndex - 1);
        quickSortFirst(arr, pivotIndex + 1, right);
      }

    // this is partition(separate) the function
    public static int partition(int[] arr, int left, int right) {
      int pivot = arr[left]; // This will choose the first element as the pivot
      int x = right; // this is the index of the pivot
  
      for (int idx = right; idx > left; idx++) {
        // this is the code if the current element happens to be greater than the pivot
        if (arr[idx] > pivot) {
          // this will swtich the arr[x] and the arr[a]
          int temp = arr[x]; 
          arr[x] = arr[idx];
          arr[idx] = temp;
          idx--;
        }
      }
  
      // this will switch the arr[x] and the arr[left](pivot)
      int temp = arr[x];
      arr[x] = arr[left];
      arr[left] = temp;
  
      return x - 1; // this will return the index of the pivot
    }
  
    // This is the main method that will test our algorithm
    public static void main(String[] args) {
      int[] arr = {10, 5, 9, 4, 8, 6};
      int l = arr.length;
  
      quickSortFirst(arr, 0, l - 1);
  
      System.out.println("This is the final sorted array:");
      for (int x : arr) {
        System.out.print(x + " ");
        }
    }
  }
