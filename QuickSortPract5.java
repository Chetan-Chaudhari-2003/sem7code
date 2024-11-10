import java.sql.Time;
import java.util.Scanner;

public class QuickSortPract5 {
    // Method to perform Quick Sort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Find pivot element such that 
            // elements smaller than pivot are on the left 
            // and elements greater than pivot are on the right
            int pivotIndex = partition(array, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Method to partition the array
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choosing the last element as pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++; // Increment index of smaller element
                swap(array, i, j); // Swap current element with the element at index i
            }
        }
        swap(array, i + 1, high); // Swap the pivot element with the element at index i + 1
        return i + 1; // Return the partitioning index
    }

    // Method to swap two elements in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Main method to test the Quick Sort implementation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] array = new int[n];

        // Input the elements of the array
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Perform Quick Sort
        quickSort(array, 0, n - 1);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}



// Enter the number of elements: 5
// Enter the elements:
// 34
// 7
// 23
// 32
// 5
// Sorted array:
// 5 7 23 32 34 
//Time Complexity:
//Best Case:O(nlogn)
//Worst Case:O(n2)

//Space Complexity:O(logn)
