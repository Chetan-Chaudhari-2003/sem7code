import java.util.Scanner;

public class KnapsackDPPract4 {
    // Function to find the maximum value that can be obtained
    public static int knapSack(int capacity, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the table dp[][] in a bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case
                } else if (weights[i - 1] <= w) {
                    // Item can be included, take the maximum of including or excluding the item
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    // Item cannot be included, carry forward the previous maximum value
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity]; // The maximum value for n items and given capacity
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input number of items
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        
        // Input capacity of the knapsack
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();
        
        int[] values = new int[n];
        int[] weights = new int[n];

        // Input values and weights for each item
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight for item " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        // Calculate maximum value
        int maxValue = knapSack(capacity, weights, values, n);
        System.out.println("Maximum value in the knapsack = " + maxValue);
        
        scanner.close();
    }
}


// Enter the number of items: 3
// Enter the capacity of the knapsack: 50
// Enter value and weight for item 1: 60 10
// Enter value and weight for item 2: 100 20
// Enter value and weight for item 3: 120 30
// Maximum value in the knapsack = 220


//c[i,w]=max{c[i−1,w−w[i]]+P[i]}

//Time Complexity: O(n * W), where n is the number of items and W is the knapsack's capacity.
//Space Complexity: O(n * W), where n is the number of items and W is the knapsack's capacity

//3
//6
//10 1
//15 2
//40 3