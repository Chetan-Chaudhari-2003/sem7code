import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Class to represent an item with its value and weight
class Item {
    double value;
    double weight;

    Item(double value, double weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalPract3 {
    // Method to calculate the maximum value that can be obtained in the knapsack
    public static double getMaxValue(Item[] items, double capacity) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                return Double.compare(b.value / b.weight, a.value / a.weight);
            }
        });

        double totalValue = 0.0; // Total value accumulated in the knapsack

        for (Item item : items) {
            if (capacity <= 0) {
                break; // If the capacity is full, break out of the loop
            }

            if (item.weight <= capacity) {
                // If the item can fit entirely, take it all
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                // Take the fraction of the item that fits
                totalValue += item.value * (capacity / item.weight);
                capacity = 0; // Knapsack is now full
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        
        // Input capacity of the knapsack
        System.out.print("Enter the capacity of the knapsack: ");
        double capacity = scanner.nextDouble();

        Item[] items = new Item[n];

        // Input values and weights for each item
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight for item " + (i + 1) + ": ");
            double value = scanner.nextDouble();
            double weight = scanner.nextDouble();
            items[i] = new Item(value, weight);
        }

        // Calculate maximum value
        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in the knapsack = " + maxValue);

        scanner.close();
    }
}


// Enter the number of items: 3
// Enter the capacity of the knapsack: 50
// Enter value and weight for item 1: 60 10
// Enter value and weight for item 2: 100 20
// Enter value and weight for item 3: 120 30
// Maximum value in the knapsack = 240.0


//3
//6
//10 1
//15 2
//40 3